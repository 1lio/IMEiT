package ru.vyaacheslav.suhov.imeit.ftagments.bells

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.data.DB
import java.util.*

class BellsFragment : Fragment() {

    lateinit var residue: TextView
    lateinit var listView: ListView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fragment_clock, container, false)
        residue = v.findViewById(R.id.is_time)
        listView = v.findViewById(R.id.time_list)
        calc()
        connectionDB()
        return v
    }

    @SuppressLint("SetTextI18n")
    private fun calc() {
        val calendar = GregorianCalendar.getInstance()
        val hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
        val minute: Int = calendar.get(Calendar.MINUTE)

        val times: Array<Int> = arrayOf(605, 710, 845, 950, 1055, 1160)
        val x = hour * 60 + minute // Получаем текущее время и переводим в минуты
        val c: Int // Значение для вычислений
        // Проверяем попадает время в промежуток, затем подставляем значение
        c = when (x) {
            in 510..605 -> times[0] - x
            in 615..710 -> times[1] - x
            in 750..845 -> times[2] - x
            in 855..950 -> times[3] - x
            in 960..1055 -> times[4] - x
            in 1065..1160 -> times[5] - x
            else -> 0
        }
        val ost: Int = c - 60

        if (c < 60) {
            residue.text = "0 ч. $c мин." // Если значение меньше, то подставляем его в минуты
        } else {
            residue.text = "1 ч. $ost мин."
        }
    }

    private fun connectionDB() {
        val lessons = DB(this.context!!).dbTimes()
        val from = arrayOf("_id", "time_top", "time_out", "pre_top", "pre_out")
        val to = intArrayOf(R.id.num_time_item, R.id.item_time_top, R.id.item_time_bottom, R.id.item_out_top, R.id.item_out_bottom)

        val adapter = SimpleAdapter(activity, lessons, R.layout.item_clock, from, to)
        listView.adapter = adapter
    }
}