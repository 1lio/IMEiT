package ru.vyaacheslav.suhov.imeit.view.ftagments.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.adapters.MapsListAdapter
import ru.vyaacheslav.suhov.imeit.viewmodel.MapsListViewModel

/** Фрагмент список с положением всех корпусов */
class MapsListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fr_recycler, container, false)
        val recycler = v.findViewById<RecyclerView>(R.id.recycler)

        val model: MapsListViewModel = ViewModelProviders.of(this)[MapsListViewModel::class.java]

        model.observeListBuilding(this, Observer {
            val adapter = MapsListAdapter(it)
            recycler.adapter = adapter
            adapter.notifyDataSetChanged()
        })

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.addItemDecoration(DividerItemDecoration(recycler.context, LinearLayoutManager(context).orientation))
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.setHasFixedSize(true)
        return v
    }
}