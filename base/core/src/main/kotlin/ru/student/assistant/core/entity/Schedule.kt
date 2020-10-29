package ru.student.assistant.core.entity

data class Schedule(

    // Числитель
    var lesson: String = "",   // Название предмета
    var teacher: String = "",  // Лектор/Преподователь
    var type: String = "",     // Тип занятия Лекция/Практика/Лабараторная
    var building: String = "", // Здание/Аудитория/Корпус проведения занятий
    // Знаменатель
    var lesson2: String = "",
    var teacher2: String = "",
    var type2: String = "",
    var building2: String = "",
    // Прочее
    var together: Int = 0,     //Флаг когда числитель и знаменатель совпадают по всем параметрам
    var note: String = "",     //Заметка к занятию, личная или информация о переносе

    var id: String = "-1"
)