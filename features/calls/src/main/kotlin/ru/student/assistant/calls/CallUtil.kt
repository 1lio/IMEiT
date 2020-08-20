package ru.student.assistant.calls

import ru.student.assistant.calls.EducationEvent.BREAK
import ru.student.assistant.calls.EducationEvent.END
import ru.student.assistant.calls.EducationEvent.LESSON
import ru.student.assistant.calls.EducationEvent.LUNCH
import ru.student.assistant.calls.repository.LocalRepository
import ru.student.core.entity.CallPref

import java.util.*
import kotlin.collections.ArrayList

/** Данный класс работает обрабатывает дополнительные возможности при созданнии списка
 *  @param pref Вы должны передать настроки */

class CallUtil(private val pref: CallPref = CallPref()) {

    private val calendar = GregorianCalendar.getInstance()
    private val currentTime =
        (calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE))

    /** @see generateListsRange - Функция создает два листа с диапазонами пар и перемен
     *  @return Pair<<List<Занятия>,List<Перемены>>*/
    private fun generateListsRange(): Pair<List<IntRange>, List<IntRange>> {

        val list: ArrayList<IntRange> = arrayListOf()   // Лист с уроками
        val pause: ArrayList<IntRange> = arrayListOf()  // Лист с переменами

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
            val changeRange =
                if (x != (pref.lunchStart - 1)) pairTo + 1..(pairTo + pref.lengthBreakPair)
                else pairTo + 1..pairTo + pref.lengthLunch

            pause.add((x + 1), changeRange)
            // обновляем счетчик
            pairFrom =
                (pairFrom + (pref.lengthLesson * 2) + pref.lengthBreak) + pref.lengthBreakPair
            if (x == (pref.lunchStart - 1)) pairFrom =
                (pairFrom + pref.lengthLunch) - pref.lengthBreakPair
        }

        return Pair(list, pause)
    }

    /** @see getNumberCurrentPair - Функция проверяет входит ли текущее время в диапазоны пар или перемен
     *  @return Pair<тип, номер> */
    fun getNumberCurrentPair(): Pair<Byte, Int> {

        var number = 0   // Номер пары
        var type = BREAK // Тип. Пара или перемена

        // Проверяем есть ли наше число в листе с диапазонами пар
        val isInclude = generateListsRange().first.any { intRange -> currentTime in intRange }
        // Если значение текущее время есть среди диапазонов пар, то найди его в списке пар и верни номер
        if (isInclude) {
            generateListsRange().first.forEachIndexed { i, r ->
                if (currentTime in r)
                    number = i
                type = LESSON
            }
        } else {
            generateListsRange().second.forEachIndexed { i, r -> if (currentTime in r) number = i }

            type = when {
                number == pref.lunchStart -> LUNCH
                currentTime > generateListsRange().first[pref.count - 1].last -> END
                else -> BREAK
            }

            // вернем первую пару если, пары закончались или еще не начинались
            if (number == pref.count) number = 0
        }
        return Pair(type, number)
    }

    fun getThisTime(): String = currentTime.timeFormat()

    /**@see getResidueTime Функция которая возвращает скользо времени осталось до конца пары или перемены*/
    fun getResidueTime(): String {
        return if (getNumberCurrentPair().first == LESSON) {
            // Вернем время до окончания пар
            ((generateListsRange().first[getNumberCurrentPair().second].last) - currentTime).remainedTimeFormat()
        } else {
            // Если пары закончились возьмем время до 00, получим текущее и отнимем до начала и вернем его
            (START_LESSONS - currentTime + pref.start).remainedTimeFormat()
        }

    }

    /** @return Список отформатированный под TimeData*/
    fun getListTime(): List<TimeData> {

        val list: MutableList<TimeData> = mutableListOf()
        var time: Int = pref.start

        // Строка сверху
        val hour = (time / 60).toString()
        val min = time % 60
        val text = (time + pref.lengthBreak + (pref.lengthLesson * 2))
        val minText = if (min == 0) "00" else min.toString()

        for (x in 1..LocalRepository().countPair) {
            list.add(TimeData(hour, minText, text.timeFormat()))

            time = (time + pref.lengthBreak + (pref.lengthLesson * 2) + pref.lengthBreakPair)

            // Большая перемена
            if (x == pref.lunchStart) time = (time + pref.lengthLunch - pref.lengthBreakPair)
        }
        return list
    }

    companion object {
        const val START_LESSONS: Int = 1440 //00.00 o'clock
    }
}