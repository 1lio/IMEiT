package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.vyaacheslav.suhov.imeit.util.UtilBell
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref

class CallTimeViewModel : ViewModel() {

    private val pairStatus = MutableLiveData<String>()
    private val timeLeft = MutableLiveData<String>()
    private val currentPair = MutableLiveData<Int>()
    private val currentTime = MutableLiveData<String>()


    init {
        currentPair.postValue(UtilBell(CallPref()).getNumberCurrentPair().second)
    }


    fun observePairStatus(owner: LifecycleOwner, observer: Observer<String>) {
        pairStatus.observe(owner, observer)
    }

    fun observeTimeLeft(owner: LifecycleOwner, observer: Observer<String>) {
        timeLeft.observe(owner, observer)
    }

    fun observeCurrentTime(owner: LifecycleOwner, observer: Observer<String>) {
        currentTime.observe(owner, observer)
    }

    fun setTime(time: String) {
        currentTime.postValue(time)
    }

    fun getPairStatus(): String = pairStatus.value ?: "error"

    fun setPairStatus(status: String) {
        pairStatus.postValue(status)
    }

    fun observePair(owner: LifecycleOwner, observer: Observer<Int>) {
        currentPair.observe(owner, observer)
    }

    fun getTimeLeft(): String = timeLeft.value ?: "error"

    fun setTimeLeft(time: String) {
        timeLeft.postValue(time)
    }
}