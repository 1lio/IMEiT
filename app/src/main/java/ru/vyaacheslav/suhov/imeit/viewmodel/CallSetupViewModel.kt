package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.orhanobut.hawk.Hawk
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.repository.FirebaseRealtimeRepository
import ru.vyaacheslav.suhov.imeit.repository.MainInteractor
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref
import ru.vyaacheslav.suhov.imeit.util.BellsGenerator
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_EDITED_CALL
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_IS_EDITED_CALL
import ru.vyaacheslav.suhov.imeit.view.adapters.entity.BellItem

class CallSetupViewModel : ViewModel() {

    private val interactor = MainInteractor(FirebaseRealtimeRepository().getInstance())
    private val compositeDisposable = CompositeDisposable()

    private val currentCallPref = MutableLiveData<CallPref>()

    private val previewList = MutableLiveData<ArrayList<BellItem>>()   //LiveData Готовый лист
    private val currentList = MutableLiveData<ArrayList<BellItem>>()

    private var pref: CallPref = CallPref()
    private var defaultPref: CallPref = CallPref()

    init {
        // Инициализируем...
        // Получаем стандартные данные из БД
        interactor.getDefaultCallPref()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    defaultPref = it
                    currentCallPref.postValue(defaultPref)
                }.apply { compositeDisposable.add(this) }


        if (Hawk.get(KEY_IS_EDITED_CALL, DEF_EDITED_CALL) == false) {
            // Грузим дефолтные настройки
            // В случае изменения дефолтных настртоек грузить из RealtimeDataBase
            pref = if (CallPref() == defaultPref) CallPref() else defaultPref // TODO:...и Отписаться от потока
        } else {
            // Грузим из БД
            interactor.getCustomCallPref()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        pref = it
                        currentCallPref.postValue(pref)
                    }.apply { compositeDisposable.add(this) }
        }

        // Заполняем текущий лист
        currentList.postValue(generateList(pref)) // Лист заполенный по умолчанию
        // Заполняем лист с превью
        previewList.postValue(generateList(pref))
    }

    fun observePreviewList(owner: LifecycleOwner, observer: Observer<ArrayList<BellItem>>) {
        previewList.observe(owner, observer)
    }

    fun getPreferences(): CallPref = currentCallPref.value!!

    fun setPref(preferences: CallPref) = currentCallPref.postValue(preferences)

    // Функция вернет сгенерированный лист
    private fun generateList(pref: CallPref): ArrayList<BellItem> = BellsGenerator(pref).getBellsList()

    fun save() {
        // Отправляем данные
        interactor.setCustomCallPref(currentCallPref.value!!)
    }

    fun cancel() {
        // Сброс до начальных данных перед изменением
        previewList.postValue(currentList.value)
    }

    fun setupDefaultPreferences() {
        previewList.postValue(generateList(defaultPref))
        Hawk.put(KEY_IS_EDITED_CALL, false)
    }
}