package core.util

import core.objects.BellCount
import core.objects.BellSetup
import core.objects.application.AppSetup

/** Данный класс генирирует лист с расписанием звонков на основе входящих данных
 *  По умолчанию класс использует стандартные настройки приложения, если они не перезагружены
 *  Класс принимает объект BellsSetup для формирования списка */

// Данный класс прошел проверку и работает нормально.
class BellsGeneratorList(bellSetup: BellSetup, appSetup: AppSetup = AppSetup()) {

    private val pref = bellSetup
    private val prefApp = appSetup

    fun convertToCountBells(): List<BellCount> {

        val list: MutableList<BellCount> = mutableListOf()
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

            val countBells = BellCount(x.toString(), firstLesson, lastLesson, breakCh, pref.lengthBreakPair.toString())
            list.add(countBells)
        }

        /** Находим где должна быть большая перемена делаем замену */
        list[pref.lunchStart - 1].botOut = pref.lengthLunch.toString()
        return list
    }

    /** @see inString - Функция переводит входящие значения в строку*/
    private fun inString(time: Int): String {

        val from = time.timeFormat()
        val to = (time + pref.lengthLesson).timeFormat()

        return "$from - $to"
    }

    /** @see timeFormat - Функция-расширение форматирует 24 двадцати четырёх часовой формат времени <00:00>
     *  @return Функция вернет отформатированную строку */
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