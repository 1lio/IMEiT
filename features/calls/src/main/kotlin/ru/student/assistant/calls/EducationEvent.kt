package ru.student.assistant.calls

/** Типы состояния учебного процесса */

object EducationEvent {
    const val LESSON: Byte = 0
    const val BREAK: Byte = 1
    const val LUNCH: Byte = 2
    const val END: Byte = 4
}