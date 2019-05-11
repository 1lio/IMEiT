package ru.vyaacheslav.suhov.imeit.view.ftagments.schedule

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
import ru.vyaacheslav.suhov.imeit.view.adapters.DayFragmentAdapter
import ru.vyaacheslav.suhov.imeit.viewmodel.DayViewModel

class FragmentDay(private val day: String): Fragment() {

    private lateinit var recycler: RecyclerView
    private lateinit var model: DayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fr_recycler, container, false)
        recycler = v.findViewById(R.id.recycler)

        model = ViewModelProviders.of(this)[DayViewModel::class.java]
        model.day = day // Передаем день

        model.observeSchedule(this, Observer {

            val adapter = DayFragmentAdapter(it)
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