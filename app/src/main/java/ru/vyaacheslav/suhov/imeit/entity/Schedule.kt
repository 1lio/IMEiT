package ru.vyaacheslav.suhov.imeit.entity

/** Расписание занятий
 * @param lesson - Название предмета
 * @param teacher - Лектор/Преподователь
 * @param type - Тип занятия Лекция/Практика/Лабараторная
 * @param building - Здание/Аудитория/Корпус проведения занятий
 *
 * Даллее данные дублируются на знаменатель
 *
 * @param together - Флаг когда числитель и знаменатель совпадают по всем параметрам
 * @param note - Заметка к занятию, личная или информация о переносе */

data class Schedule(
        // Числитель
        var lesson: String = "",
        var teacher: String = "",
        var type: String = "",
        var building: String = "",
        // Знаменатель
        var lesson2: String = "",
        var teacher2: String = "",
        var type2: String = "",
        var building2: String = "",
        // Прочее
        var together: Int = 0,
        var note: String = ""
)