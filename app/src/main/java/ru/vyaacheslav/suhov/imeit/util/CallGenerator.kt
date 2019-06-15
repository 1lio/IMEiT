package ru.vyaacheslav.suhov.imeit.util

import ru.vyaacheslav.suhov.imeit.view.adapters.entity.CallItem
import ru.vyaacheslav.suhov.imeit.entity.CallPref

/** Данный класс генерирует лист с расписанием звонков
 *  @param pref - настроки для расписания из класса [CallPref]*/

class CallGenerator(private val pref: CallPref) {

    /** @see getCallsList - Функция конвертирует входящие данные
     * @return  возвращается лист с расписанием звонков*/
    fun getCallsList(): ArrayList<CallItem> {

        val list: ArrayList<CallItem> = arrayListOf()
        var time: Int = pref.start // Начинать формирование расписание со значения начала пар,

        // В цикле соберм лист с расписанием
        for (x in 1..pref.count) {
            // Строка сверху
            val firstLesson = toTimeFormat(time)
            time = (time + pref.lengthLesson)

            // Строка снизу
            val lastLesson = toTimeFormat((time + pref.lengthBreak))
            time = (time + pref.lengthBreakPair + pref.lengthLesson + pref.lengthBreak)

            // Большая перемена
            if (x == pref.lunchStart) time = (time + pref.lengthLunch - pref.lengthBreakPair)

            // Создаем и добовляем CallItem в список
            list.add(CallItem(x.toString(), firstLesson, lastLesson, pref.lengthBreak.toString(),
                    pref.lengthBreakPair.toString()))
        }

        // Находим где должна быть большая перемена делаем замену
        if (list.size >= 2) list[pref.lunchStart - 1].bottomBreak = pref.lengthLunch.toString()

        // Находим последюю перемену и затираем
        list[pref.count - 1].bottomBreak = ""
        return list
    }

    /** @see toTimeFormat - Функция-свойство форматирует строку <10:15 - 11:00> */
    val toTimeFormat = { t: Int -> "${t.timeFormat()} - ${(t + pref.lengthLesson).timeFormat()}" }
}