package ru.vyaacheslav.suhov.imeit.util

import android.content.Context
import android.os.Build
import android.widget.TextView
import ru.vyaacheslav.suhov.imeit.R

fun TextView.styleAppearance(context: Context) {
    if (Build.VERSION.SDK_INT < 23) {
        this.setTextAppearance(context, R.style.TextCurrentPair)
    } else {
        this.setTextAppearance(R.style.TextCurrentPair)
    }
}

/** @return Функция-расширение возвращает строку в 24-часовом формате <00:00> */
 fun Int.timeFormat(): String {
    // Получим остаток от текущего значения
    val hour = this / 60   // Часы
    val min = this % 60    // Минуты
    // Сформатируем строку
    val hh: String = if (hour < 10) "0$hour" else "$hour"
    val mm: String = if (min < 10) "0$min" else "$min"
    // Вернем отформатированную строку
    return "$hh:$mm"
}
