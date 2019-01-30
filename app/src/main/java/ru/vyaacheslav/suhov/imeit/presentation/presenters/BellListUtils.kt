package ru.vyaacheslav.suhov.imeit.presentation.presenters

import ru.vyaacheslav.suhov.imeit.domain.entity.BellSettings
import java.util.*

/** Данный класс работает обрабатывает дополнительные возможности при созданнии списка
 *  @param pref Вы должны передать настроки */

class BellListUtils(private val pref: BellSettings) {

    /** @see TimeEvent Типы состоянияний времени */
    enum class TimeEvent { LESSON, BREAK, LUNCH }

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
        for (x in 0..(pref.count - 1)) {
            // Добовляем первую пару
            val pairTo = pairFrom + ((pref.lengthLesson * 2) + pref.lengthBreak)
            val pairRange: IntRange = pairFrom..pairTo
            list.add(x, pairRange)
            // добовляем перемену
            val changeRange = if (x != (pref.lunchStart - 1)) pairTo + 1..(pairTo + pref.lengthBreakPair) else pairTo + 1..pairTo + pref.lengthLunch
            pause.add((x + 1), changeRange)
            // обновляем счетчик
            pairFrom = (pairFrom + (pref.lengthLesson * 2) + pref.lengthBreak) + pref.lengthBreakPair
            if (x == (pref.lunchStart - 1)) pairFrom = (pairFrom + pref.lengthLunch) - pref.lengthBreakPair
        }

        return Pair(list, pause)
    }

    /** @see getNumberCurrentPair - Функция проверяет входит ли текущее время в диапазоны пар или перемен
     *  @return тип и номер */
    fun getNumberCurrentPair(): Pair<TimeEvent, Int> {

        var number = 0  // Номер пары
        var type: TimeEvent = TimeEvent.BREAK// Тип. Пара или перемена

        // Проверяем есть ли наше число в листе с диапазонами пар
        val isInclude = generateListsRange().first.any { intRange -> getCurrentTime in intRange }
        // Если значение текущее время есть среди диапазонов пар, то найди его в списке пар и верни номер
        if (isInclude) {
            generateListsRange().first.forEachIndexed { index, intRange ->
                if (getCurrentTime in intRange) number = index
                type = TimeEvent.LESSON
            }
        } else {
            generateListsRange().second.forEachIndexed { index, intRange ->
                if (getCurrentTime in intRange) number = index
            }
            type = if (number != pref.lunchStart) TimeEvent.BREAK else TimeEvent.LUNCH
            // вернем первую пару если, пары закончались или еще не начинались
            if (number == pref.count) number = 0
        }

        return Pair(type, number)
    }

    /**@see getResidueTime Функция которая возвращает скользо времени осталось до конца пары или перемены*/
    val getResidueTime: String =
            if (getNumberCurrentPair().first == TimeEvent.LESSON) {
                // Вернем время до окончания пар
                ((generateListsRange().first[getNumberCurrentPair().second].endInclusive) - getCurrentTime).timeFormat()
            } else {
                // Вернем время до конца перемены
                if (getNumberCurrentPair().second != pref.count) {
                    ((generateListsRange().second[getNumberCurrentPair().second].endInclusive) - getCurrentTime).timeFormat()
                } else ((1440 - getCurrentTime) + pref.start).timeFormat() // Если пары закончились возьмем время до 00, получим текущее и отнимем до начала и вернем его
            }

    /** @return Функция-расширение возвращает строку в 24-часовом формате времени <00:00> */
    private fun Int.timeFormat(): String {

        val hour = this / 60   // Часы
        val min = this % 60    // Минуты

        // Форматируем строку
        val hourStr: String = if (hour < 10) "0$hour" else hour.toString()
        val minStr: String = if (min < 10) "0$min" else min.toString()

        // Вернем строку
        return "$hourStr:$minStr"
    }
}