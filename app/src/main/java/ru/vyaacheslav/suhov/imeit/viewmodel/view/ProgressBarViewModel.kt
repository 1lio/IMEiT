package ru.vyaacheslav.suhov.imeit.viewmodel.view

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class ProgressBarViewModel : ViewModel() {

    private val textData = MutableLiveData<String>()
    private val progressData = MutableLiveData<Int>()
    private val visibilityData = MutableLiveData<Boolean>()

    fun observeTextProgress(owner: LifecycleOwner,observer: Observer<String>) {
        textData.observe(owner, observer)
    }

    fun observeProgress(owner: LifecycleOwner, observer: Observer<Int>) {
        progressData.observe(owner, observer)
    }

    fun observeVisibility(owner: LifecycleOwner,observer: Observer<Boolean>) {
        visibilityData.observe(owner, observer)
    }
}