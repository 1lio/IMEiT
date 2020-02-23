package ru.vyaacheslav.suhov.imeit.view.ftagments.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fr_recycler.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.base.BaseFragment
import ru.vyaacheslav.suhov.imeit.view.adapters.MapsListAdapter
import ru.vyaacheslav.suhov.imeit.viewmodel.LocationViewModel

/** Фрагмент список с положением всех корпусов */
class MapsListFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model: LocationViewModel = ViewModelProvider(this)[LocationViewModel::class.java]
        val adapter = MapsListAdapter()

        recycler.adapter = adapter

        model.observeListBuilding(this@MapsListFragment, Observer { adapter.addAllAndNotify(it) })

        recycler.addItemDecoration(
            DividerItemDecoration(
                recycler.context,
                LinearLayoutManager(context).orientation
            )
        )
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.setHasFixedSize(true)
    }
}