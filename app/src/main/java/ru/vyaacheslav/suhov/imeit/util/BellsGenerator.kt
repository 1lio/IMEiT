package ru.vyaacheslav.suhov.imeit.util

import ru.vyaacheslav.suhov.imeit.view.adapters.entity.BellCount
import ru.vyaacheslav.suhov.imeit.view.adapters.entity.BellData

/** Данный класс генерирует лист с расписанием звонков
 *  @param data - настроки для расписания из класса*/

class BellsGenerator(private val data: BellData) {

    /** @see getBellsList - Функция конвертирует входящие данные и возвращает лист с расписанием звонков*/
    fun getBellsList(): List<BellCount> {

        val list: MutableList<BellCount> = mutableListOf()
        var time: Int = data.start // Начинать формирование расписание со значения начала пар,

        // В цикле соберм лист с расписанием
        for (x in 1..data.count) {
            // Строка сверху
            val firstLesson = toLesson(time)
            time = (time + data.lengthLesson)

            // Строка снизу
            val lastLesson = toLesson((time + data.lengthBreak))
            time = (time + data.lengthBreakPair + data.lengthLesson + data.lengthBreak)

            // Большая перемена
            if (x == data.lunchStart) time = (time + data.lengthLunch - data.lengthBreakPair)

            // Создаем и добовляем объект в список
            list.add(BellCount(x.toString(), firstLesson, lastLesson, data.lengthBreak, data.lengthBreakPair))
        }
        // Находим где должна быть большая перемена делаем замену
        list[data.lunchStart - 1].bottomBreak = data.lengthLunch

        // Вернем неизменяемый лист
        return list
    }

    /** @see toLesson - Функция-свойство форматирует строку <10:15 - 11:00> */
    val toLesson = { t: Int -> "${t.timeFormat()} - ${(t + data.lengthLesson).timeFormat()}" }

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