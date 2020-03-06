package ru.suhov.student.viewmodel

import androidx.lifecycle.*

class AuthSignInModel : ViewModel() {

    private val isValidForm = MutableLiveData<Boolean>()

    init {
        isValidForm.value = false
    }

    fun observeForm(owner: LifecycleOwner, observer: Observer<Boolean>) {
        isValidForm.observe(owner, observer)
    }

    fun setValidForm(isValid: Boolean) {
        isValidForm.value = isValid
    }

    fun getValidForm() = isValidForm.value
}