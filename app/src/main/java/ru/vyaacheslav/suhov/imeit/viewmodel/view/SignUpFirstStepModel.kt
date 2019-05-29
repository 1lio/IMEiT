package ru.vyaacheslav.suhov.imeit.viewmodel.view

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class SignUpFirstStepModel : ViewModel() {

    private val isValidateAll = MutableLiveData<Boolean>()

    init {
        isValidateAll.value = false
    }

    fun observeValidAll(owner: LifecycleOwner, observer: Observer<Boolean>) {
        isValidateAll.observe(owner, observer)
    }

    fun setValidAll(b: Boolean) {
        isValidateAll.postValue(b)
    }
}