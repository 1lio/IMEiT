package ru.vyaacheslav.suhov.imeit.util

import android.content.Context
import android.os.Build
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.util.Constants.FRI
import ru.vyaacheslav.suhov.imeit.util.Constants.MON
import ru.vyaacheslav.suhov.imeit.util.Constants.THU
import ru.vyaacheslav.suhov.imeit.util.Constants.TUE
import ru.vyaacheslav.suhov.imeit.util.Constants.WED
import java.util.*

/** В данном файле хранятся функции которые могут быть вызваны когда-либо мне зависимости от класса*/

/** @return Стиль текста подсвеченого item например: номер текущей пары или локация */
fun TextView.styleAppearance(context: Context) {
    if (Build.VERSION.SDK_INT < 23) this.setTextAppearance(context, R.style.TextCurrentPair)
    else this.setTextAppearance(R.style.TextCurrentPair)
}

/** @return Функция-расширение возвращает строку в 24-часовом формате <00:00> */
fun Int.timeFormat(): String {
    // Получим остаток от текущего значения
    val hour = if ((this / 60) > 24) (this / 60) - 24 else this / 60   // Часы
    val min = this % 60    // Минуты
    // Сформатируем строку
    val hh: String = if (hour < 10) "0$hour" else "$hour"
    val mm: String = if (min < 10) "0$min" else "$min"
    // Вернем отформатированную строку
    return "$hh:$mm"
}

/** @return Вернется строка вида "mon" соответсвующая текущему дню кроме выходных(тогда"mon"). */
fun getDayAcronym(): String = when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
    Calendar.TUESDAY -> TUE
    Calendar.WEDNESDAY -> WED
    Calendar.THURSDAY -> THU
    Calendar.FRIDAY -> FRI
    else -> MON
}

fun toast(context: Context, msg: Int) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}

fun View.visible() { this.visibility = View.VISIBLE }

fun View.gone() { this.visibility = View.GONE }

fun Fragment.pushFragment(fm: FragmentManager) {
    fm.beginTransaction().replace(R.id.container, this, this.tag).commit()
}