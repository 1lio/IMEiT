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

class FragmentDay(private val day: String) : Fragment() {

    private lateinit var model: DayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this)[DayViewModel::class.java]
        model.setDay(day)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fr_recycler, container, false)

        val recycler: RecyclerView = v.findViewById(R.id.recycler)
        val adapter = DayFragmentAdapter()
        recycler.adapter = adapter

        model.setSchedule(day)
        model.observeSchedule(this, Observer {
            adapter.addAllAndNotify(it)
        })

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.addItemDecoration(DividerItemDecoration(recycler.context, LinearLayoutManager(context).orientation))
        return v
    }
}