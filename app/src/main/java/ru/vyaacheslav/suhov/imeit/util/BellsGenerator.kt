package ru.vyaacheslav.suhov.imeit.util

import ru.vyaacheslav.suhov.imeit.view.adapters.entity.BellCount
import ru.vyaacheslav.suhov.imeit.view.adapters.entity.BellPref

/** Данный класс генерирует лист с расписанием звонков
 *  @param pref - настроки для расписания из класса*/

class BellsGenerator(private val pref: BellPref) {

    /** @see getBellsList - Функция конвертирует входящие данные и возвращает лист с расписанием звонков*/
    fun getBellsList(): List<BellCount> {

        val list: MutableList<BellCount> = mutableListOf()
        var time: Int = pref.start // Начинать формирование расписание со значения начала пар,

        // В цикле соберм лист с расписанием
        for (x in 1..pref.count) {
            // Строка сверху
            val firstLesson = toLesson(time)
            time = (time + pref.lengthLesson)

            // Строка снизу
            val lastLesson = toLesson((time + pref.lengthBreak))
            time = (time + pref.lengthBreakPair + pref.lengthLesson + pref.lengthBreak)

            // Большая перемена
            if (x == pref.lunchStart) time = (time + pref.lengthLunch - pref.lengthBreakPair)

            // Создаем и добовляем BellCount в список
            list.add(BellCount(x.toString(), firstLesson, lastLesson, pref.lengthBreak.toString(), pref.lengthBreakPair.toString()))
        }

        // Находим где должна быть большая перемена делаем замену
        list[pref.lunchStart - 1].bottomBreak = pref.lengthLunch.toString()

        // Находим последюю нижнюю перемену и затираем
        list[pref.count-1].bottomBreak = ""

        return list
    }

    /** @see toLesson - Функция-свойство форматирует строку <10:15 - 11:00> */
    val toLesson = { t: Int -> "${t.timeFormat()} - ${(t + pref.lengthLesson).timeFormat()}" }

    /** @return Функция-расширение возвращает строку в 24-часовом формате <00:00> */
    private fun Int.timeFormat(): String {
        // Получим остаток от текущего значения
        val hour = this / 60   // Часы
        val min = this % 60    // Минуты
        // Сформатируем строку
        val hh: String = if (hour < 10) "0$hour" else "$hour"
        val mm: String = if (min < 10) "0$min" else "$min"
        // Вернем отформатированную строку
        return "$hh:$mm"
    }
}