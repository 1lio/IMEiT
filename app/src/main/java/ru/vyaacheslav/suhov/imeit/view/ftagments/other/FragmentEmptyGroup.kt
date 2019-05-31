package ru.vyaacheslav.suhov.imeit.view.ftagments.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.vyaacheslav.suhov.imeit.R

class FragmentEmptyGroup : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_empty, container, false)
    }
}