package ru.vyaacheslav.suhov.imeit.ftagments.bells


//TODO: ПЕРЕДЕЛАТЬ!
import android.content.Context
import ru.vyaacheslav.suhov.imeit.R
import java.lang.Exception
import java.util.*

/** В данном классе производем расчеты остатка времени до конца парыдля других классов приложения
 *  @author Сухов Вячеслав
 *  @version 1.0
 *  @see getResidueTimePair - Функция вернет остаток вермени до конца пары (в минутах)
 *  @see getNumberCurrentPair - Функция вернет номер текущей пары или той которая будет,
 *  если пара не попала не в один диапозон
 *  @see getTypePair - Функция вернет тип пары, точнее диапозон: Пара, Большая перемена, Перемена, Каникулы */

class BellsUtils {

    /** Получим дату, час и минуту с календаря */

    private val calendar: Calendar = GregorianCalendar.getInstance()
    private val date: Int = calendar.get(Calendar.DATE)
    private val hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
    private val min: Int = calendar.get(Calendar.MINUTE)

    /** Переведем часы в минуты */
    private val thisTime = hour * 60 + min

    /** Коллекция пар в минутах */

    // TODO: Данные нужно брать из БД и ковертировать
    private val pairMinutes: Array<Int> = arrayOf(605, 710, 845, 950, 1055, 1160)

    /** Число хранящее время окончания большой перемены и диапозон в который она входит*/
    private val lunch: Int = 750
    private val lunchRage: IntRange = 711..749

    /** Коллекция диапозонов*/
    private val pairIntervals: Array<IntRange> = arrayOf((510..605), (615..710), (750..845),
            (855..950), (960..1055), (1065..1160))

    /** @return Функция вернет сколько осталось минут до конца пары*/
    fun getResidueTimePair(): Int {

        /** Переменная в которой вернем время до конца пары в минутах */
        var minutes = 0
        /** Переберем значения: если наше время входит в диапозон то врени остаток до конца пары*/
        for (x in 0..(pairIntervals.size-1)) {
            if (thisTime in pairIntervals[x]) {
                minutes = pairMinutes[x] - thisTime
                break
            }
        }
        return minutes
    }

    /** @return Функция вернет номер пары
     *  @return 9 - Большая перемена*/
    fun getNumberCurrentPair(): Int {
        var numPair = 0
        for (x in 0..(pairIntervals.size -1)) {
            if (thisTime in pairIntervals[x]) {
                numPair = x
                break
            }
        }
        return numPair
    }

    /** @return функция возвращая тип текущей пары в виде строки
     *  @param context - Необходим для доступа к ресурсам приложения
     *  @param vacationFrom - Дата начала каникул
     *  @param vacationTo - Дата окончания каникул, может быть null если мы хотим получить тип кроме каникул*/
    fun getTypePair(context: Context, vacationFrom: Int?, vacationTo: Int?): String {
        var typePair = "dsd"
        typePair = if (thisTime in lunchRage) context.resources.getString(R.string.time_lunch) else context.resources.getString(R.string.time_residue)
        typePair = try {
            if ((vacationFrom!! < date) && (vacationTo!! > date)) "До конца каникул осталось!" else "S"
        } catch (e: Exception) {
            "Error"
        }
        return typePair
    }
}