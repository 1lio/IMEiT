package ru.vyaacheslav.suhov.imeit.view.adapters.entity

/** В данном классе описываются поля данных для формирования списка BellsList

 * @param id Порядковый номер
 * @param count Колличество пар
 * @param start Начало занятий
 * @param lengthLesson Продолжительность урока
 * @param lengthBreak Продолжительность перемены
 * @param lengthLunch Продолжительность большой перемены
 * @param lengthBreakPair Продолжительность перемены между парами
 * @param lunchStart Большая перемена после <номер пары>
 */

data class BellData(
        val id: Int = 0,
        val count: Int = 6,
        val start: Int = 510,
        val lengthLesson: Int = 45,
        val lengthBreak: Int = 5,
        val lengthLunch: Int = 40,
        val lengthBreakPair: Int = 10,
        val lunchStart: Int = 2
)