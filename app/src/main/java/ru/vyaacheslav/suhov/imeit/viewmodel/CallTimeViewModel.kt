package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.base.BaseViewModel
import ru.vyaacheslav.suhov.imeit.util.UtilBell
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref
import ru.vyaacheslav.suhov.imeit.util.CallGenerator
import ru.vyaacheslav.suhov.imeit.view.adapters.entity.CallItem
import ru.vyaacheslav.suhov.imeit.view.ftagments.calls.CallFragment
import ru.vyaacheslav.suhov.imeit.view.view.TimeView

/** Данную вью модель используют [CallFragment] и [TimeView]*/

class CallTimeViewModel : BaseViewModel() {

    private val pairStatus = MutableLiveData<String>()
    private val timeLeft = MutableLiveData<String>()
    private val currentPair = MutableLiveData<Int>()
    private val currentTime = MutableLiveData<String>()

    private var pref = CallPref()
    private val prefData = MutableLiveData<CallPref>()
    private val listData = MutableLiveData<ArrayList<CallItem>>()

    init {
        // В начале нужно проверить измененно ли расписание звонков
        // затем грузим из FirebaseRealtimeDatabase нужные данные
        if (localRepository.isCustomScheduleCall) customPref() else defaultPref()

        // генерируем лист из полученных настроек
        listData.postValue(CallGenerator(pref).getCallsList())

        // Получаем номер текущей пары
        currentTime
        currentPair.postValue(UtilBell(CallPref()).getNumberCurrentPair().second)
    }

    // Статус текущей пары
    fun observePairStatus(owner: LifecycleOwner, observer: Observer<String>) {
        pairStatus.observe(owner, observer)
    }

    // Сколько времени до звонка/начала пар
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

    //Устанавливаем текущее время
    fun setTime(time: String) {
        currentTime.postValue(time)
    }

    fun setPairStatus(status: String) {
        pairStatus.postValue(status)
    }

    fun getPref() = prefData.value ?: CallPref()  // <- Умышленный Косяк!! | Переделать

    fun setTimeLeft(time: String) {
        timeLeft.postValue(time)
    }

    private fun defaultPref() {

        // Тут можно проверить дефолтны ли дефолтные настройки и в след раз не лезть на сервер
        // и использовать просто CallPref()

        interactor.getDefaultCallPref()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    pref = it
                    prefData.postValue(pref)
                }.apply { compositeDisposable.add(this) }
    }

    private fun customPref() {
        // Пользовательские установки
        // Вообще все пользовательское будет храниться только локально, делаю так для ДЗ
        interactor.getCustomCallPref()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    pref = it
                    prefData.postValue(pref)
                }.apply { compositeDisposable.add(this) }
    }
}