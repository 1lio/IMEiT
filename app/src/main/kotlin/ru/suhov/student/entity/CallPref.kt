package ru.suhov.student.entity

/** CallPref - Установки для времени вонков
 *
 * @param count Колличество пар
 * @param start Начало занятий
 * @param lengthLesson Продолжительность урока
 * @param lengthBreak Продолжительность перемены
 * @param lengthLunch Продолжительность большой перемены
 * @param lengthBreakPair Продолжительность перемены между парами
 * @param lunchStart Большая перемена после <номер пары>
 */

data class CallPref(
    var count: Int = 6,
    var start: Int = 510,
    var lengthLesson: Int = 45,
    var lengthBreak: Int = 5,
    var lengthLunch: Int = 40,
    var lengthBreakPair: Int = 10,
    var lunchStart: Int = 2
)