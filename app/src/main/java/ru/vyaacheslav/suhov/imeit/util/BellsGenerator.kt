package ru.vyaacheslav.suhov.imeit.util

import ru.vyaacheslav.suhov.imeit.view.adapters.entity.BellItem
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref

/** Данный класс генерирует лист с расписанием звонков
 *  @param pref - настроки для расписания из класса*/

class BellsGenerator(private val pref: CallPref) {

    /** @see getBellsList - Функция конвертирует входящие данные и возвращает лист с расписанием звонков*/
    fun getBellsList(): ArrayList<BellItem> {

        val list: ArrayList<BellItem> = arrayListOf()
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

            // Создаем и добовляем BellItem в список
            list.add(BellItem(x.toString(), firstLesson, lastLesson, pref.lengthBreak.toString(), pref.lengthBreakPair.toString()))
        }

        // Находим где должна быть большая перемена делаем замену
        list[pref.lunchStart - 1].bottomBreak = pref.lengthLunch.toString()

        // Находим последюю нижнюю перемену и затираем
        list[pref.count-1].bottomBreak = ""

        return list
    }

    /** @see toLesson - Функция-свойство форматирует строку <10:15 - 11:00> */
    val toLesson = { t: Int -> "${t.timeFormat()} - ${(t + pref.lengthLesson).timeFormat()}" }
}