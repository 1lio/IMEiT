package ru.vyaacheslav.suhov.imeit.view.ftagments.calls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.base.BaseFragment
import ru.vyaacheslav.suhov.imeit.view.adapters.CallListFragmentAdapter
import ru.vyaacheslav.suhov.imeit.viewmodel.CallTimeViewModel

/** Фрагмент показывающий список с расписанием звонков и также View с информацией о текущем времени*/
class CallFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fr_time, container, false)

        val recycler: RecyclerView = v.findViewById(R.id.recycler_time)
        val adapter = CallListFragmentAdapter()
        val viewModel = ViewModelProvider(activity!!)[CallTimeViewModel::class.java]

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.addItemDecoration(DividerItemDecoration(recycler.context, LinearLayoutManager(context).orientation))

        viewModel.observeListCalls(activity!!, Observer { adapter.addAllAndNotify(it) })
        return v
    }
}