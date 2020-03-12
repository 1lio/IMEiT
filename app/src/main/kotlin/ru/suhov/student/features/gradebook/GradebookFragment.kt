package ru.suhov.student.features.gradebook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.suhov.student.R

class GradebookFragment(private val semester: Byte) : Fragment() {

    override fun onCreateView(inf: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inf, group, state)
        return inf.inflate(R.layout.gradebook, group, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}