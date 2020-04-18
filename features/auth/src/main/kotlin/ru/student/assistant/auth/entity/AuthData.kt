package ru.student.assistant.auth.entity

import ru.student.core.entity.User

data class AuthData(
    var email: String = "",
    var pass: String = "",
    var user: User = User()
)