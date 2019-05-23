package ru.vyaacheslav.suhov.imeit.util

/** Типы состояния учебного процесса */

// Еще наверно можно добавить каникулы, сессия, карантин и пр.

object EducationEvent {
    const val LESSON = 0
    const val BREAK = 1
    const val LUNCH = 2
    const val END = 4
}