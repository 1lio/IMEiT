package ru.student.assistant.schedule.features.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fr_recycler.*
import ru.student.assistant.schedule.R
import ru.suhov.student.features.viewmodel.DayViewModel

/** Фрагмент с расписанием для текущего дня*/
class FragmentDay(private val day: String) : Fragment() {

    private lateinit var model: DayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProvider(this)[DayViewModel::class.java]
        model.setDay(day)
    }

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? =
        inflater.inflate(R.layout.fr_recycler, group, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = DayFragmentAdapter()
        recycler.adapter = adapter

        model.setSchedule(day)
        model.observeSchedule(viewLifecycleOwner, { adapter.addAllAndNotify(it) })

        recycler.itemAnimator = DefaultItemAnimator()
        recycler.addItemDecoration(
            DividerItemDecoration(
                recycler.context,
                LinearLayoutManager(context).orientation
            )
        )
    }
}