package ru.vyaacheslav.suhov.imeit.view.ftagments.maps

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.DB

/** Фрагмент список с положением всех корпусов ЕГУ */
class MapsListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fr_map_list, container, false)
        val s = DB(this.context!!).dbMaps()

        // Формируем список мз двух полей БД
        val from = arrayOf("name", "address")
        val to = intArrayOf(R.id.text1, R.id.text2)

        // Формируем и выводим в UI
        val adapter = SimpleAdapter(activity, s, R.layout.item_maps, from, to)
        val listView = v.findViewById<ListView>(R.id.mapListView)

        // Обрабатываем нажатия по элементам списка
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, _, id ->
            // Создаем интент и отправляем на гугл карты
            val addressLoc: Uri = Uri.parse("geo:0,0?q=${s[id.toInt()]["address"]}")
            val agr = Intent(Intent.ACTION_VIEW, addressLoc)
            agr.setPackage("com.google.android.apps.maps")
            startActivity(agr)
        }
        listView.adapter = adapter
        return v
    }
}