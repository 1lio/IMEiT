package ru.assistant.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class ContainerViewModel: ViewModel() {

    private val isVisibleAppBar = MutableLiveData<Boolean>()
    private val isVisibleFAB = MutableLiveData<Boolean>()

    init {

        isVisibleAppBar.value = false
        isVisibleFAB.value = false
    }

    fun setVisibleAppBar(visible:Boolean) {
        isVisibleAppBar.value = visible
    }

    fun setVisibleFAB(visible:Boolean) {
        isVisibleFAB.value = visible
    }

    fun observeVisibleAppBar(owner: LifecycleOwner, observer: Observer<Boolean>) {
        isVisibleAppBar.observe(owner, observer)
    }

    fun observeVisibleFAB(owner: LifecycleOwner, observer: Observer<Boolean>) {
        isVisibleFAB.observe(owner, observer)
    }

}