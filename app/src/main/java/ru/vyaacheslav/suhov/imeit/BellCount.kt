package ru.vyaacheslav.suhov.imeit

/** @see BellCount Объект описывает ячейку времени звонков*/
data class BellCount(var num: String,
                     var topLesson: String,
                     var bottomLesson: String,
                     var topBreak: Int,
                     var bottomBreak: Int)