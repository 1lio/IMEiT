package ru.student.assistant.auth.viewmodel

import androidx.lifecycle.*

class SignInViewModel : ViewModel() {

    private val isValidForm = MutableLiveData<Boolean>()
    private val isFocusedForm = MutableLiveData<Boolean>()

    init {
        isValidForm.value = false
        isFocusedForm.value = false
    }

    fun observeFocusable(owner: LifecycleOwner, observer: Observer<Boolean>) {
        isFocusedForm.observe(owner, observer)
    }

    fun observeForm(owner: LifecycleOwner, observer: Observer<Boolean>) {
        isValidForm.observe(owner, observer)
    }

    fun setFocusedForm(isFocused:Boolean) {
        isFocusedForm.value = isFocused
    }

    fun setValidForm(isValid: Boolean) {
        isValidForm.value = isValid
    }

}
