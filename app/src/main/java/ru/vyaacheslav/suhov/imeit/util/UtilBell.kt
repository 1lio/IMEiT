package ru.vyaacheslav.suhov.imeit.util

import ru.vyaacheslav.suhov.imeit.repository.LocalRepository
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref
import ru.vyaacheslav.suhov.imeit.util.EducationEvent.BREAK
import ru.vyaacheslav.suhov.imeit.util.EducationEvent.END
import ru.vyaacheslav.suhov.imeit.util.EducationEvent.LESSON
import ru.vyaacheslav.suhov.imeit.util.EducationEvent.LUNCH
import ru.vyaacheslav.suhov.imeit.view.adapters.entity.TimeData
import java.util.*

/** Данный класс работает обрабатывает дополнительные возможности при созданнии списка
 *  @param pref Вы должны передать настроки */

class UtilBell(private val pref: CallPref = CallPref()) {


    /** @see getCurrentTime текущее время*/
    private val calendar = GregorianCalendar.getInstance()
    private val getCurrentTime: Int = (calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE))

    /** @see generateListsRange - Функция создает два листа с диапазонами пар и перемен
     *  @return Pair<<List<Занятия>,List<Перемены>>*/
    private fun generateListsRange(): Pair<List<IntRange>, List<IntRange>> {

        val list: MutableList<IntRange> = mutableListOf()   // Лист с уроками
        val pause: MutableList<IntRange> = mutableListOf()  // Лист с переменами

        // Добавим время до начала занятий
        pause.add(0, 0..pref.start)
        var pairFrom: Int = pref.start

        // создаем лист в цикле, отнимаем 1 потому что счет начинается с нуля
        for (x in 0 until pref.count) {
            // Добовляем первую пару
            val pairTo = pairFrom + ((pref.lengthLesson * 2) + pref.lengthBreak)
            val pairRange: IntRange = pairFrom..pairTo

            list.add(x, pairRange)
            // добовляем перемену
            val changeRange = if (x != (pref.lunchStart - 1)) pairTo + 1..(pairTo + pref.lengthBreakPair)
            else pairTo + 1..pairTo + pref.lengthLunch

            pause.add((x + 1), changeRange)
            // обновляем счетчик
            pairFrom = (pairFrom + (pref.lengthLesson * 2) + pref.lengthBreak) + pref.lengthBreakPair
            if (x == (pref.lunchStart - 1)) pairFrom = (pairFrom + pref.lengthLunch) - pref.lengthBreakPair
        }

        return Pair(list, pause)
    }

    /** @see getNumberCurrentPair - Функция проверяет входит ли текущее время в диапазоны пар или перемен
     *  @return Pair<тип, номер> */
    fun getNumberCurrentPair(): Pair<Int, Int> {

        var number = 0  // Номер пары
        var type: Int = BREAK// Тип. Пара или перемена

        // Проверяем есть ли наше число в листе с диапазонами пар
        val isInclude = generateListsRange().first.any { intRange -> getCurrentTime in intRange }
        // Если значение текущее время есть среди диапазонов пар, то найди его в списке пар и верни номер
        if (isInclude) {
            generateListsRange().first.forEachIndexed { index, intRange ->
                if (getCurrentTime in intRange) number = index
                type = LESSON
            }
        } else {
            generateListsRange().second.forEachIndexed { i, r -> if (getCurrentTime in r) number = i }

            type = when {
                number == pref.lunchStart -> LUNCH
                getCurrentTime > generateListsRange().first[pref.count - 1].endInclusive -> END
                else -> BREAK
            }

            // вернем первую пару если, пары закончались или еще не начинались
            if (number == pref.count) number = 0
        }
        return Pair(type, number)
    }

    fun getThisTime(): String = getCurrentTime.timeFormat()

    /**@see getResidueTime Функция которая возвращает скользо времени осталось до конца пары или перемены*/
    fun getResidueTime(): String {
        return if (getNumberCurrentPair().first == LESSON) {
            // Вернем время до окончания пар
            ((generateListsRange().first[getNumberCurrentPair().second].endInclusive) - getCurrentTime).timeFormat()
        } else {
            (1440 - getCurrentTime + pref.start).timeFormat() // Если пары закончились возьмем время до 00, получим текущее и отнимем до начала и вернем его
        }

    }

    /** @return Список отформатированный под TimeData*/
    fun getListTime(): List<TimeData> {

        val list: MutableList<TimeData> = mutableListOf()
        var time: Int = pref.start

        for (x in 1..LocalRepository().countPair) {

            // Строка сверху
            val hour = (time / 60).toString()

            val min = time % 60
            val text = (time + pref.lengthBreak + (pref.lengthLesson * 2))

            val minText = if (min == 0) "00" else min.toString()
            list.add(TimeData(hour, minText, text.timeFormat()))

            time = (time + pref.lengthBreak + (pref.lengthLesson * 2) + pref.lengthBreakPair)
            // Большая перемена
            if (x == pref.lunchStart) time = (time + pref.lengthLunch - pref.lengthBreakPair)
        }
        return list
    }
}