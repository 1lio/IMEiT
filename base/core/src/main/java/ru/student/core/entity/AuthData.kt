package ru.student.core.entity

data class AuthData(
    var email: String = "",
    var pass: String = "",
    var user: User = User()
)