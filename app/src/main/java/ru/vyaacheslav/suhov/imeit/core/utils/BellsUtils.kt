package ru.vyaacheslav.suhov.imeit.core.utils

import ru.vyaacheslav.suhov.imeit.core.CountBells
import ru.vyaacheslav.suhov.imeit.core.PreferencesBells
import java.util.*

/** Класс для работы с данными PrefBells
 * @author SukhovViacheslav
 * @version 1.0 */

class BellsUtils(bellsPreferences: PreferencesBells) {

    private val pref = bellsPreferences

    /** @see convertToCountBells - Функция конвертирования данных и формирование списка
     *  @return Вернем лист объектов CountBells*/

    /** Получим дату, час и минуту с календаря */

    private val calendar: Calendar = GregorianCalendar.getInstance()
    private val date: Int = calendar.get(Calendar.DATE)
    private val hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
    private val min: Int = calendar.get(Calendar.MINUTE)

    /** Переведем часы в минуты */
    private val thisTime = hour * 60 + min

    // TODO: Переименовать!!!
    private fun getPairMinutes(): List<Int> {

        val list: MutableList<Int> = mutableListOf()
        var count: Int = pref.startPairs

        for (x in 0..pref.countPairs) {
            count = (count + ((pref.lengthLesson * 2) + pref.lengthBreak))
            list.add(count)
            count = (count + ((pref.lengthLesson * 2) + pref.lengthBreak) + pref.lengthBreakPair)
            if (x == pref.lunchStart) count = (count + pref.lengthBreak) - pref.lengthBreakPair
        }
        return list
    }

    private val pairMinutes: List<Int> = getPairMinutes()

    fun convertToCountBells(): List<CountBells> {

        val list: MutableList<CountBells> = mutableListOf()
        var time: Int = pref.startPairs

        var firstLesson: String
        var lastLesson: String

        val breakCh: String = pref.lengthBreak.toString()
        var pickerTimer = 0

        for (x in 1..pref.countPairs) {
            if (x == 1) {
                /** заполним первую пару */
                firstLesson = inString(time)
                time = (time + pref.lengthLesson)
                lastLesson = inString((time + pref.lengthBreak))
                pickerTimer = time + pref.lengthBreakPair + pref.lengthLesson + pref.lengthBreak

            } else {
                /** Делам тоже самое, но данные подставляем из обновляемого pickerTime */
                firstLesson = inString(pickerTimer)
                time = (pickerTimer + pref.lengthLesson)
                lastLesson = inString((pickerTimer + pref.lengthBreak + pref.lengthLesson))
                pickerTimer = time + pref.lengthBreakPair + pref.lengthLesson + pref.lengthBreak

                if (x == pref.lunchStart) {
                    pickerTimer = (pickerTimer + pref.lengthLunch - pref.lengthBreakPair)
                }
            }

            val countBells = CountBells(x.toString(), firstLesson, lastLesson, breakCh, pref.lengthBreakPair.toString())
            list.add(countBells)
        }

        /** Находим где должна быть большая перемена и туда впиндюриваем */
        list[pref.lunchStart - 1].botOut = pref.lengthLunch.toString()
        return list
    }

    /** @see inString - Функция переводит входящие значения в строку*/
    private fun inString(time: Int): String {

        val from: String = time.convertInTime()
        val to: String = (time + pref.lengthLesson).convertInTime()

        return "$from - $to"
    }

    /** @see convertInTime - Функция переводит минуты и часы и возвращает строку */
    private fun Int.convertInTime(count: Int = 0): String {
        val hour = count + this / 60   // Часы
        val min = count + this % 60    // Минуты

        // Форматируем строку
        val hourStr: String = if (hour < 10) "0$hour" else hour.toString()
        val minStr: String = if (min < 10) "0$min" else min.toString()

        return "$hourStr:$minStr"
    }

    /** @see getPairRange - Конвертируем данные для формирования диапазонов пар */

    fun getPairRange(): List<IntRange> {

        val list: MutableList<IntRange> = mutableListOf()
        var counter: Int = pref.startPairs

        for (x in 0..pref.countPairs) {
            val range: IntRange = counter..counter + ((pref.lengthLesson * 2) + pref.lengthBreak)
            list.add(x, range)
            counter = (counter + ((pref.lengthLesson * 2) + pref.lengthBreak) + pref.lengthBreakPair)
            if (x == pref.lunchStart) counter = (counter + pref.lengthBreak) - pref.lengthBreakPair
        }

        return list
    }

    /** Коллекция диапозонов
     * @see getNumberCurrentPair - Функция вернет номер пары
     *  @return - Большая перемена*/
    fun getNumberCurrentPair(): Int {
        var numPair = 0
        for (x in 0..(pref.countPairs)) {
            if (thisTime in getPairRange()[x]) {
                numPair = x
                break
            }
        }
        return numPair
    }

    /** @return Функция вернет сколько осталось минут до конца пары*/
    fun getResidueTimePair(): Int {

        /** Переменная в которой вернем время до конца пары в минутах */
        var minutes = 0
        /** Переберем значения: если наше время входит в диапозон то врени остаток до конца пары*/
        for (x in 0..(getPairRange().size - 1)) {
            if (thisTime in getPairRange()[x]) {
                minutes = pairMinutes[x] - thisTime
                break
            }
        }
        return minutes
    }

}