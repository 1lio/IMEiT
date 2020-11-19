package ru.assistant.auth.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    private val isValidForms = MutableLiveData<Boolean>()
    private val checkBox = MutableLiveData<Boolean>()

    init {
        isValidForms.value = false
        checkBox.value = false
    }

    fun observeForm(owner: LifecycleOwner, observer: Observer<Boolean>) {
        isValidForms.observe(owner, observer)
    }

    fun observerCheckBox(owner: LifecycleOwner, observer: Observer<Boolean>) {
        checkBox.observe(owner, observer)
    }

    fun getCheck() = checkBox.value ?: false

    fun setValidForm(b: Boolean) {
        isValidForms.postValue(b)
    }

    fun setCheck(b: Boolean) {
        checkBox.value = b
    }

}
