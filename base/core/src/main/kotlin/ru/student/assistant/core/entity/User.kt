package ru.student.assistant.core.entity

data class User(
    var uId: String? = "",

    var name: String = "",

    var institute: String = "",
    var faculty: String = "",
    var group: String = ""
)