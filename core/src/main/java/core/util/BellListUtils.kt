package core.util

import core.objects.BellSetup
import java.util.*

/** Данный класс работает обрабатывает дополнительные возможности при созданнии списка
 * @see BellListUtils.convertEuropeFormat - данная функция конвертирует время в амер. формат*/

class BellListUtils(setup: BellSetup = BellSetup()) {

    val pref = setup

    /** Получим дату, час и минуту с календаря */

    private val calendar: Calendar = GregorianCalendar.getInstance()
    private val date: Int = calendar.get(Calendar.DATE)
    private val hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
    private val min: Int = calendar.get(Calendar.MINUTE)

    /** Переведем часы в минуты */
    private val thisTime = hour * 60 + min


    private val pairMinutes: List<Int> = getListPairMinutes()

    /** Получим лист с парами в минутах*/
    private fun getListPairMinutes(): List<Int> {

        val list: MutableList<Int> = mutableListOf()
        var count: Int = pref.startPairs

        for (x in 1..pref.countPairs) {
            if (x == 1) count = (count + ((pref.lengthLesson * 2) + pref.lengthBreak))
            list.add(count)
            count = (count + ((pref.lengthLesson * 2) + pref.lengthBreak) + pref.lengthBreakPair)
            if (x == pref.lunchStart) count = (count + pref.lengthBreak) - pref.lengthBreakPair
        }
        return list
    }


    /** @see getPairRange - Конвертируем данные для формирования диапазонов пар */

    private fun getPairRange(): List<IntRange> {

        val list: MutableList<IntRange> = mutableListOf()
        var counter: Int = pref.startPairs

        for (x in 0..(pref.countPairs - 1)) {
            // Добовляем первую пару
            val range: IntRange = counter..counter + ((pref.lengthLesson * 2) + pref.lengthBreak)
            list.add(x, range)
            counter = (counter + ((pref.lengthLesson * 2) + pref.lengthBreak) + pref.lengthBreakPair)
            if (x == (pref.lunchStart - 1)) counter = (counter + pref.lengthLunch) - pref.lengthBreakPair
        }

        return list
    }

    /** Коллекция диапозонов
     * @see getNumberCurrentPair - Функция вернет номер пары
     *  @return - Большая перемена*/
    fun getNumberCurrentPair(): Int {
        var numPair = 0
        for (x in 0..(pref.countPairs - 1)) {
            if (thisTime in getPairRange()[x]) {
                numPair = x
                break
            }
        }
        return numPair
    }

    /** @return Функция вернет сколько осталось минут до конца пары*/
    //TODO: БАГ
    fun getResidueTimePair(): Int {

        return getListPairMinutes()[getNumberCurrentPair()] - thisTime
    }
}

