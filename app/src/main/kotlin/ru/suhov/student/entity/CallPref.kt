package ru.suhov.student.entity

data class CallPref(
    var count: Int = 6,             // Колличество пар
    var start: Int = 510,           // Начало занятий
    var lengthLesson: Int = 45,     // Продолжительность урока
    var lengthBreak: Int = 5,       // Продолжительность перемены
    var lengthLunch: Int = 40,      // Продолжительность большой перемены
    var lengthBreakPair: Int = 10,  // Продолжительность перемены между парами
    var lunchStart: Int = 2         // Большая перемена после <номер пары>
)