package ru.student.assistant.auth.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthVM : ViewModel() {

    private val state = MutableLiveData<Byte>()



    private companion object {
        const val SIGN_IN: Byte = 0
        const val SIGN_UP: Byte = 1
        const val RESTORE: Byte = 2
    }

}