package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.base.BaseViewModel
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref
import ru.vyaacheslav.suhov.imeit.util.CallGenerator
import ru.vyaacheslav.suhov.imeit.util.Constants.CUSTOM
import ru.vyaacheslav.suhov.imeit.util.Constants.DEFAULT
import ru.vyaacheslav.suhov.imeit.util.UtilBell
import ru.vyaacheslav.suhov.imeit.view.adapters.entity.CallItem
import ru.vyaacheslav.suhov.imeit.view.ftagments.calls.CallFragment
import ru.vyaacheslav.suhov.imeit.view.view.TimeView

/** Данную вью модель используют [CallFragment] и [TimeView]*/
class CallTimeViewModel : BaseViewModel() {

    private val pairStatus = MutableLiveData<Int>()
    private val timeLeft = MutableLiveData<String>()

    private val currentPair = MutableLiveData<Int>()
    private val currentTime = MutableLiveData<String>()

    private var pref: CallPref = CallPref()
    private val prefData = MutableLiveData<CallPref>()

    private var list: ArrayList<CallItem> = arrayListOf()
    private val listData = MutableLiveData<ArrayList<CallItem>>()

    private val utils = UtilBell(pref)

    private val defPrefData = MutableLiveData<CallPref>()
    private var defPref = CallPref()

    init {
        // В начале нужно проверить измененно ли расписание звонков и загрузить нужные данные
        if (localRepository.isChangedPref) getPref() else getDefaultPref()

        // Получаем номер текущей пары
        currentPair.postValue(utils.getNumberCurrentPair().second)
        // Обновляем значения во viewModel
        // Текущее форматированное время
        currentTime.postValue(utils.getThisTime())
        // Соклько осталось
        timeLeft.postValue(utils.getResidueTime())
        // Текущий статус пары
        pairStatus.postValue(utils.getNumberCurrentPair().first)
    }

    fun getPrefData(): CallPref = prefData.value ?: pref

    fun saveAndPush(preferences: CallPref) {
        // Ставим что у нас кастомные настройки звонков
        localRepository.isChangedPref = true
        // Сохраняем колличество пар
        localRepository.countPair = pref.count
        // Отправляем данные
        interactor.setCustomCallPref(preferences)
    }

    fun setDefaultPreferences() {
       // getDefaultPref()
        prefData.value = defPref
        saveAndPush(defPref)  // Кастомные настройки затираем дефолтными
        localRepository.isChangedPref = false
    }

    fun getPref() {
        interactor.getCallPref(CUSTOM)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    pref = it

                    list.clear()
                    list = CallGenerator(pref).getCallsList()

                    prefData.postValue(pref)
                    listData.postValue(CallGenerator(it).getCallsList())
                }.apply { compositeDisposable.add(this) }
    }

    private fun getDefaultPref() {
        interactor.getCallPref(DEFAULT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    defPref = it

                    list.clear()
                    list = CallGenerator(it).getCallsList()

                    defPrefData.postValue(defPref)
                    listData.postValue(CallGenerator(it).getCallsList())
                }.apply { compositeDisposable.add(this) }
        setDefaultPreferences()
    }

    // Наблюдатель статус текущей пары
    fun observePairStatus(owner: LifecycleOwner, observer: Observer<Int>) {
        pairStatus.observe(owner, observer)
    }

    // Наблюдатель времени до звонка/начала пар
    fun observeTimeLeft(owner: LifecycleOwner, observer: Observer<String>) {
        timeLeft.observe(owner, observer)
    }

    // Наблюдатель за текущим временем
    fun observeCurrentTime(owner: LifecycleOwner, observer: Observer<String>) {
        currentTime.observe(owner, observer)
    }

    // Наблюдатель списка звонков
    fun observeListCalls(owner: LifecycleOwner, observer: Observer<ArrayList<CallItem>>) {
        listData.observe(owner, observer)
    }
}