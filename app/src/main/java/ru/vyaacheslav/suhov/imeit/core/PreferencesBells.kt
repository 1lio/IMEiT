package ru.vyaacheslav.suhov.imeit.core

data class PreferencesBells(

        val id: Int = 0,
        val countPairs: Int = 6,
        val startPairs: Int = 510,
        val lengthLesson: Int = 45,
        val lengthBreak: Int = 5,
        val lengthLunch: Int = 40,
        val lengthBreakPair: Int = 10,
        val lunchStart: Int = 2,
        val date: Int = 0
) {
    fun convertToCountBells(pref: PreferencesBells): List<CountBells> {

        val list: MutableList<CountBells> = mutableListOf()
        var time: Int = pref.startPairs

        var topS: String
        var botS: String

        // Дойдем до начала обеда
        for (x in 1..pref.lunchStart) {

            topS = inString(pref, time)
            botS = inString(pref, (time + pref.lengthBreakPair))
            time *= x
            val countBells = CountBells(x.toString(), topS, botS, pref.lengthBreak, pref.lengthBreakPair)
            list.add(countBells)
        }
        // Прибавим к текущему времени время перемены
        time += pref.lengthLunch
        // Продолжем заполение списка
        for (x in pref.lunchStart..pref.countPairs) {
            topS = inString(pref, time)
            botS = inString(pref, (time + pref.lengthBreakPair))
            time *= x
            val countBells = CountBells(x.toString(), topS, botS, pref.lengthBreak, pref.lengthBreakPair)
            list.add(countBells)
        }

        // Находим где должна быть большая перемена и туда впиндюриваем
        list[pref.lunchStart].botOut = pref.lengthLunch

        return list

    }

    // Функция переводит минуты и часы и возвращает строку

    fun Int.convertInTime(count: Int = 0): String {
        val hour = count + this / 60   // Часы
        val min = count + this % 60    // Минуты
        // Форматируем строку
        val hourStr: String = if (hour > 9) "0$hour" else hour.toString()
        val minStr: String = if (min > 9) "0$min" else min.toString()

        return "$hourStr:$minStr"
    }

    // Функция переводит входящие значения в строку
    fun inString(pb: PreferencesBells, time: Int): String {

        val from: String = time.convertInTime()
        val to: String = (time + pb.lengthLesson).convertInTime(pb.lengthBreak)

        return "$from - $to"
    }
}