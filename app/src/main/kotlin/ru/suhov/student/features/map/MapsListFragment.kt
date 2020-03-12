package ru.suhov.student.features.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fr_recycler.*
import ru.suhov.student.R
import ru.suhov.student.features.viewmodel.LocationViewModel

/** Фрагмент список с положением всех корпусов */
class MapsListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?): View? =
         inflater.inflate(R.layout.fr_recycler, container, false)

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