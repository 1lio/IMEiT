package ru.vyaacheslav.suhov.imeit.core

/** В данном классе описываются поля данных для формирования списка BellsList
 * @author SukhovViacheslav
 * @version 1.0
 *
 * @param id  - Порядковый номер
 * @param countPairs - Колличество пар
 * @param startPairs - Начало занятий
 * @param lengthLesson - Продолжительность урока
 * @param lengthBreak - Продолжительность перемены
 * @param lengthLunch - Продолжительность большой перемены
 * @param lengthBreakPair -Продолжительность перемены между парами
 * @param lunchStart - Большая перемена после <номер пары>
 * @param date - Дата изменеия по дефолту 0*/

data class PreferencesBells(

        val id: Int = 0,
        val countPairs: Int = 6,
        val startPairs: Int = 510,
        val lengthLesson: Int = 45,
        val lengthBreak: Int = 5,
        val lengthLunch: Int = 40,
        val lengthBreakPair: Int = 10,
        val lunchStart: Int = 2,
        val date: Int = 0) {

    /** @see convertToCountBells - Функция конвертирования данных из PreferencesBells и формирование списка
     *  @param pref - настрока
     *  @return Вернем лист объектов CountBells*/

    fun convertToCountBells(pref: PreferencesBells): List<CountBells> {

        val list: MutableList<CountBells> = mutableListOf()
        var time: Int = pref.startPairs

        var firstLesson: String
        var lastLesson: String

        val breakCh: String =  pref.lengthBreak.toString()
        var pickerTime = 0

        for (x in 1..pref.countPairs) {
            if (x == 1) {
                // заполним первую пару
                firstLesson = inString(pref, time)
                time = (time + pref.lengthLesson)
                lastLesson = inString(pref, (time + pref.lengthBreak))
                pickerTime = time + pref.lengthBreakPair + pref.lengthLesson + pref.lengthBreak

            } else {
                // Делам тоже самое, но берем данные из pickerTime
                firstLesson = inString(pref, pickerTime)
                time = (pickerTime + pref.lengthLesson)
                lastLesson = inString(pref, (pickerTime + pref.lengthBreak + pref.lengthLesson))
                pickerTime = time + pref.lengthBreakPair + pref.lengthLesson + pref.lengthBreak

                if (x == pref.lunchStart) {
                    pickerTime = (pickerTime + pref.lengthLunch - pref.lengthBreakPair)
                }
            }

            val countBells = CountBells(x.toString(), firstLesson, lastLesson, breakCh, pref.lengthBreakPair.toString())
            list.add(countBells)
        }

        // Находим где должна быть большая перемена и туда впиндюриваем
        list[pref.lunchStart - 1].botOut = pref.lengthLunch.toString()
        return list
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

    /** @see inString - Функция переводит входящие значения в строку*/
    private fun inString(pb: PreferencesBells, time: Int): String {

        val from: String = time.convertInTime()
        val to: String = (time + pb.lengthLesson).convertInTime()

        return "$from - $to"
    }
}