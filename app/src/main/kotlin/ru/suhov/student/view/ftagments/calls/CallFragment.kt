package ru.suhov.student.view.ftagments.calls

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
import androidx.recyclerview.widget.RecyclerView
import ru.suhov.student.R
import ru.suhov.student.view.adapters.CallListFragmentAdapter
import ru.suhov.student.viewmodel.CallTimeViewModel

/** Фрагмент показывающий список с расписанием звонков и также View с информацией о текущем времени*/
class CallFragment : Fragment() {

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