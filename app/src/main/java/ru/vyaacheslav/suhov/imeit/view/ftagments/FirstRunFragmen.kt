package ru.vyaacheslav.suhov.imeit.view.ftagments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.vyaacheslav.suhov.imeit.R

class FirstRunFragmen : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_first_run, container,false)

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}