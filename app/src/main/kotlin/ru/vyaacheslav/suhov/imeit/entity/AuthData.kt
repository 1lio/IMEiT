package ru.vyaacheslav.suhov.imeit.entity

data class AuthData(
    var email: String = "",
    var pass: String = "",
    var user: User = User()
)