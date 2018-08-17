package ru.vyaacheslav.suhov.imeit.ftagments.schedule

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.vyaacheslav.suhov.imeit.R

class TemporarySchedule : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_not_shedule, container, false)
        return v
    }
}