package ru.suhov.student.features.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.suhov.student.core.platform.BaseViewModel
import ru.suhov.student.core.entity.CallPref
import ru.suhov.student.features.gateway.TimeCallInteractorImpl
import ru.suhov.student.core.util.CallGenerator
import ru.suhov.student.core.util.CallUtil
import ru.suhov.student.features.call.CallItem
import ru.suhov.student.features.call.CallFragment
import ru.suhov.student.features.call.TimeView

/** Данную вью модель используют [CallFragment] и [TimeView]*/
class CallTimeViewModel : BaseViewModel() {

    private val interactor = TimeCallInteractorImpl().getInstance()

    private val pairStatus = MutableLiveData<Byte>()
    private val timeLeft = MutableLiveData<String>()

    private val numberPair = MutableLiveData<Int>()
    private val currentTime = MutableLiveData<String>()

    private var pref: CallPref = CallPref()
    private val prefData = MutableLiveData<CallPref>()

    private var list: ArrayList<CallItem> = arrayListOf()
    private val listData = MutableLiveData<ArrayList<CallItem>>()

    // Дефолтные настройки
    private val defPrefData = MutableLiveData<CallPref>()
    private var defPref = CallPref()

    init {
        // В начале нужно проверить измененно ли расписание звонков и загрузить нужные данные
        getCurrentPref()

        updateTime()

        // Грузим дефолтные настройки в любом случае
        getDefaultPref()
    }

    fun getPrefData(): CallPref = prefData.value ?: pref

    fun saveAndPush(preferences: CallPref) {
        // Сохраняем колличество пар
        localRepository.countPair = pref.count
        // Отправляем данные
        interactor.updateUserCallsPref(preferences, localRepository.userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
            .apply { compositeDisposable.add(this) }
    }

    fun setDefaultPreferences() {
        interactor.getDefaultTimeCallPref()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ defPrefData.postValue(it) }, {})
            .apply { compositeDisposable.add(this) }

        pref = defPrefData.value ?: defPref
        prefData.postValue(pref)
        saveAndPush(defPref)  // Кастомные настройки затираем дефолтными
    }

    fun getCurrentPref() {
        interactor.getUserTimePref(localRepository.userId)
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
        interactor.getDefaultTimeCallPref()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                defPref = it
                defPrefData.postValue(defPref)
            }, {})
            .apply { compositeDisposable.add(this) }
    }

    private fun updateTime() {
        val utils = CallUtil(pref)
        // Получаем номер текущей пары
        numberPair.postValue(utils.getNumberCurrentPair().second)
        // Обновляем значения во viewModel
        // Текущее форматированное время
        currentTime.postValue(utils.getThisTime())
        // Соклько осталось
        timeLeft.postValue(utils.getResidueTime())
        // Текущий статус пары
        pairStatus.postValue(utils.getNumberCurrentPair().first)
    }

    // Наблюдатель статус текущей пары
    fun observePairStatus(owner: LifecycleOwner, observer: Observer<Byte>) {
        pairStatus.observe(owner, observer)
    }

    // Наблюдатель времени до звонка/начала пар
    fun observeTimeLeft(owner: LifecycleOwner, observer: Observer<String>) {
        timeLeft.observe(owner, observer)
    }

    // Наблюдатель списка звонков
    fun observeListCalls(owner: LifecycleOwner, observer: Observer<ArrayList<CallItem>>) {
        listData.observe(owner, observer)
    }

    // Наблюдатель за настройками
    fun observeCalls(owner: LifecycleOwner, observer: Observer<CallPref>) {
        prefData.observe(owner, observer)
    }
}