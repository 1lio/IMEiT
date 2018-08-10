package ru.vyaacheslav.suhov.imeit.ftagments.maps

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.data.DB

class MapsList : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.map_list, container, false)

        val s = DB(this.context!!).dbMaps()

        val from = arrayOf("name", "addres")
        val to = intArrayOf(R.id.text1, R.id.text2)

        val adapter = SimpleAdapter(activity, s, R.layout.maps_item, from, to)
        val listView = v.findViewById<ListView>(R.id.mapListView)

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, _, id ->

            val addressLoc: Uri = Uri.parse("geo:0,0?q=${s[id.toInt()]["addres"]}")

            val agr = Intent(Intent.ACTION_VIEW, addressLoc)
            agr.setPackage("com.google.android.apps.maps")
            startActivity(agr)
        }
        listView.adapter = adapter
        return v
    }
}