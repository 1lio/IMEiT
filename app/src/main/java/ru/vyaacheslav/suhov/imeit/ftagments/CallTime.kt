package ru.vyaacheslav.suhov.imeit.ftagments

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import ru.vyaacheslav.suhov.imeit.R
import java.util.*

class CallTime : Fragment() {

    lateinit var prefs: SharedPreferences
    lateinit var regular: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val v = inflater.inflate(R.layout.time_clock, container, false)

        prefs = PreferenceManager.getDefaultSharedPreferences(activity)
        regular = prefs.getString(getString(R.string.pref_theme), "")

        val w1: TextView = v.findViewById(R.id.w1)
        val w2: TextView = v.findViewById(R.id.w2)
        val w3: TextView = v.findViewById(R.id.w3)
        val w4: TextView = v.findViewById(R.id.w4)
        val w5: TextView = v.findViewById(R.id.w5)
        val w6: TextView = v.findViewById(R.id.w6)
        val t5: TextView = v.findViewById(R.id.t5)
        val t6: TextView = v.findViewById(R.id.t6)
        val t7: TextView = v.findViewById(R.id.t7)
        val t8: TextView = v.findViewById(R.id.t8)
        val t10: TextView = v.findViewById(R.id.t10)
        val t11: TextView = v.findViewById(R.id.t11)
        val t12: TextView = v.findViewById(R.id.t12)
        val t13: TextView = v.findViewById(R.id.t13)
        val t14: TextView = v.findViewById(R.id.t14)
        val t15: TextView = v.findViewById(R.id.t15)
        val t16: TextView = v.findViewById(R.id.t16)
        val t17: TextView = v.findViewById(R.id.t17)
        val t19: TextView = v.findViewById(R.id.t19)
        val t20: TextView = v.findViewById(R.id.t20)
        val t21: TextView = v.findViewById(R.id.t21)
        val t22: TextView = v.findViewById(R.id.t22)
        val t24: TextView = v.findViewById(R.id.t24)
        val t25: TextView = v.findViewById(R.id.t25)
        val t26: TextView = v.findViewById(R.id.t26)
        val t27: TextView = v.findViewById(R.id.t27)
        val t29: TextView = v.findViewById(R.id.t29)
        val t30: TextView = v.findViewById(R.id.t30)
        val t31: TextView = v.findViewById(R.id.t31)
        val t32: TextView = v.findViewById(R.id.t32)

        val lss: LinearLayout = v.findViewById(R.id.mainTime)
        when (regular) {
            "Светлая" -> lss.background = ResourcesCompat.getDrawable(resources, R.color.colorPrimaryA, null)
            "Темная" -> lss.background = ResourcesCompat.getDrawable(resources, R.color.colorPrimary, null)
        }
        // Обоссаный календарь не хочет работать в 24 часовом формате, если явно указать HOUR_OF_DAY, ему еще нужно указть локаль.
        val time = Calendar.getInstance(Locale("RU", "ru"))
        val hour: Int = time.get(Calendar.HOUR_OF_DAY)
        val min: Int = time.get(Calendar.MINUTE)

        when {
            (hour == 8) && (min > 30) -> itemColor(listOf(w1, t5, t6, t7, t8))
            (hour == 9) && (min < 59) -> itemColor(listOf(w1, t5, t6, t7, t8))

            (hour == 10) && (min > 15) -> itemColor(listOf(w2, t10, t11, t12, t13))
            (hour == 11) && (min < 50) -> itemColor(listOf(w2, t10, t11, t12, t13))

            (hour == 12) && (min > 30) -> itemColor(listOf(w3, t14, t15, t16, t17))
            (hour == 13) && (min > 1) -> itemColor(listOf(w3, t14, t15, t16, t17))

            (hour == 14) && (min > 15) -> itemColor(listOf(w4, t19, t20, t21, t22))
            (hour == 15) && (min < 50) -> itemColor(listOf(w4, t19, t20, t21, t22))

            (hour == 16) && (min < 59) -> itemColor(listOf(w5, t24, t25, t26, t27))
            (hour == 17) && (min < 45) -> itemColor(listOf(w5, t24, t25, t26, t27))

            (hour == 17) && (min > 45) -> itemColor(listOf(w6, t29, t30, t31, t32))
            (hour == 18) && (min < 59) -> itemColor(listOf(w6, t29, t30, t31, t32))
        }
        return v
    }

   private fun itemColor(vs: List<TextView>) {
       // API 26 ругается что метод getColor устраел, однако судя по статистике телов с андроидом 8.0 ни у кого нет, так что пока менять не буду
        when (regular) {
            "Светлая" -> vs.forEach { it.setTextColor(resources.getColor(R.color.colorAccentA)) } //  forEach идет по всему списку, как же я тебя долго искал сука..
            "Темная" -> vs.forEach { it.setTextColor(resources.getColor(R.color.colorAccent)) }
        }
    }
}