package ru.assistant.auth.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class RestoreViewModel : ViewModel() {

    private val isValid = MutableLiveData<Boolean>()

    fun observeForm(owner: LifecycleOwner, observer: Observer<Boolean>) {
        isValid.observe(owner, observer)
    }

    fun setValidForm(value:Boolean){
        isValid.value = value
    }

}