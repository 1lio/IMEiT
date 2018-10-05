package ru.vyaacheslav.suhov.imeit.core

import java.util.*

//TODO: Данный клас должен быть в отдельном модуле

/** Данный класс реализует полную работу с времннными диапазонами учебного процесса :з
 *  @author Sukhov Viacheslav
 *  @version 1.0 */

class EducationalProcess {

    /** @see getAllStatistic - Получить всю статистику
     *  @param table - Обязательное поле которое принимает
     *  @return Вернет всю статистику у виде ArrayList<Int> данные в минутах*/

    fun getAllStatistic(table: List<BellsTable>): Array<Int> {
        /** Конвертируем данные */
        convertingData(table)
        /** Возвращаем полученную статистику */
        return getPairInfo()
    }

    /** @see isVacation - Проверка: есть ли сейчас каникулы | Вхождение для логики
     *  @see getNumCurrentSemester - Получим номер текущего полугодия
     *  @see getCurrentWeek - Получим текущую неделю (числитель или знаменатель)
     *  @see getNumCurrentSemesterThisGrouop - Номер семестра для текущей группы
     *  @see getResidueSemesterFrom - Остаток времени до начала семестра
     *  @see getResidueSemesterTo - Отсток до конца семестра
     *  @see getResidueSessionFrom - До начала сессии осталось
     *  @see getResidueSessionTo - До конца сессии осталось */

    /** Получим текущию дату и время и сохраним в переменные для дальнейшей работы */

    private val calendar: Calendar = GregorianCalendar.getInstance()
    private val date: Int = calendar.get(Calendar.DATE)
    private val hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
    private val min: Int = calendar.get(Calendar.MINUTE)

    /** Функции ковертации
     * @see itTime - конвертируем текущее время в минуты
     * @see itDate - Конвертируем текущую дату в минуты */

    val itTime = hour * 60 * min
    val itDate = date * hour * 60 * min


    /** @see convertingResult - Переменная для хранения результата конвертации
     *@see convertingData - Функция конвертации данных из БД*/
    var convertingResult: List<Pair> = listOf()

    /**  @param watchConverting - Ожидает ArrayList полученный из БД*/
    private fun convertingData(watchConverting: List<BellsTable>): List<Pair> {

        val listPair: MutableList<Pair> = mutableListOf()


        for (x in 0..watchConverting.size) {

            val startFirstLesson = watchConverting[x].topStr.toInt(1)

            val endFirstLesson: Int = 0

            val breakLesson = watchConverting[x].botInt

            val startLastLesson: Int = 0
            val endLastLesson: Int = 0

            val betweenPair: Int = watchConverting[x].outBotInt


            val pair = Pair(x, startFirstLesson, endFirstLesson, breakLesson, startLastLesson, endLastLesson, betweenPair)
            listPair.add(pair)
        }



        convertingResult = listPair
        return listPair
    }


    /** @see getPairInfo - Вернем информацию ввиде массива*/
    private fun getPairInfo(): Array<Int> {

        /** countPair - Общее колличество пар
         *  startPair - Время начала пар
         *  finalPair - Время окончания пар
         *  bigChange - Продолжительность большой перемены(всё в минутах)
         *  durationPair - Продолжительность одной пары с переменой между парами */

        /** Длинна перемен у разных институтов может быть разная, поэтому находим среднее арифметическое
         * всех пар, а затем пару больше этого числа. т.к. большая перемена может быть после первой пары,
         * но это в теории... Данное правили не распростроняется на продолжительность пар*/

        /** countMaxBreak - максимальная длинна перемены */
        var countMaxBreak = 0
        val durationPairMin: Int = convertingResult[0].startFirstLesson + convertingResult[0].startLastLesson + convertingResult[0].breakLesson

        for (x in 0..convertingResult.size) {
            var sum = convertingResult[x].betweenPair
            sum += x
            if (sum < convertingResult[x].betweenPair) countMaxBreak = convertingResult[x].betweenPair
        }

        val countPair: Int = convertingResult.size
        val startPair: Int = convertingResult[0].startFirstLesson
        val finalPair: Int = convertingResult[countPair].endLastLesson
        val bigChange: Int = convertingResult[countMaxBreak].betweenPair
        val durationPair: Int = durationPairMin


        return arrayOf(countPair, startPair, finalPair, bigChange, durationPair)
    }


    /** Класс описывающий пару*/
    data class Pair(val numPair: Int,
                    val startFirstLesson: Int,
                    val endFirstLesson: Int,
                    val breakLesson: Int,
                    val startLastLesson: Int,
                    val endLastLesson: Int,
                    val betweenPair: Int)
}