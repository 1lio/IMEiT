package ru.student.assistant.auth.viewmodel

object AuthState {
    const val SIGN_IN: Byte = 0
    const val SIGN_UP: Byte = 1
    const val SIGN_OUT: Byte = 2
    const val CONNECTED: Byte = 3
    const val RESTORE: Byte = 4
    const val CHECKING: Byte = 5
}