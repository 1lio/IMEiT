package ru.vyaacheslav.suhov.imeit.repository.entity

data class Schedule(
        var lesson: String = "",
        var teacher: String = "",
        var type: String = "",
        var building: String = "",
        var lesson2: String = "",
        var teacher2: String = "",
        var type2: String = "",
        var building2: String = "",
        var together: Int = 0,
        var note: String = ""
)