package ru.vyaacheslav.suhov.imeit.entity

// Данные для создания аккаунта

data class AuthData(var email: String = "",
                    var pass: String = "",
                    var user: User = User())