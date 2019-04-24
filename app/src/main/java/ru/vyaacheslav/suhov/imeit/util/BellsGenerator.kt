package ru.vyaacheslav.suhov.imeit.util


/** Данный класс генерирует лист с расписанием звонков
 *  @param setup - настроки для расписания из класса*/

class BellsGenerator(private val setup: BellData) {

    /** @see getBellsList - Функция конвертирует входящие данные и возвращает лист с расписанием звонков*/
    fun getBellsList(): List<BellCount> {

        val list: MutableList<BellCount> = mutableListOf()
        var time: Int = setup.start // Начинать формирование расписание со значения начала пар,

        // В цикле соберм лист с расписанием
        for (x in 1..setup.count) {

            // Строка сверху
            val firstLesson = toLesson(time)
            time = (time + setup.lengthLesson)

            // Строка снизу
            val lastLesson = toLesson((time + setup.lengthBreak))
            time = (time + setup.lengthBreakPair + setup.lengthLesson + setup.lengthBreak)

            // Большая перемена
            if (x == setup.lunchStart) time = (time + setup.lengthLunch - setup.lengthBreakPair)

            // Создаем и добовляем объект в список
            val countBells = BellCount(x.toString(), firstLesson, lastLesson,
                    setup.lengthBreak, setup.lengthBreakPair)
            list.add(countBells)
        }

        // Находим где должна быть большая перемена делаем замену
        list[setup.lunchStart - 1].bottomBreak = setup.lengthLunch

        // Вернем неизменяемый лист
        return list
    }

    /** @see toLesson - Функция-свойство форматирует строку <10:15 - 11:00> */
    val toLesson = { time: Int -> "${time.timeFormat()} - ${(time + setup.lengthLesson).timeFormat()}" }

    /** @return Функция-расширение возвращает строку в 24-часовом формате <00:00> */
    private fun Int.timeFormat(): String {
        // Получим остаток от текущего значения
        val hour = this / 60   // Часы
        val min = this % 60    // Минуты

        // Сформатируем строку
        val hh: String = if (hour < 10) "0$hour" else "$hour"
        val mm: String = if (min < 10) "0$min" else "$min"

        // Вернем отформатированную строку
        return "$hh:$mm"
    }
}