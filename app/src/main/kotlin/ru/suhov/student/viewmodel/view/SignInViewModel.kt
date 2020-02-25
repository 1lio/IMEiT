package ru.suhov.student.viewmodel.view

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {

    private val isCorrectSignForm = MutableLiveData<Boolean>()

    init {
        isCorrectSignForm.value = false
    }

    fun observeForms(owner: LifecycleOwner, observer: Observer<Boolean>) {
        isCorrectSignForm.observe(owner, observer)
    }

    fun setEnabledAll(b: Boolean) {
        isCorrectSignForm.value = b
    }
}