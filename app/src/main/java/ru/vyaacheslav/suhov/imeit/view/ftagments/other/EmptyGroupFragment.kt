package ru.vyaacheslav.suhov.imeit.view.ftagments.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.viewmodel.MainViewModel

class EmptyGroupFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fr_empty, container, false)

        val fab: FloatingActionButton = activity!!.findViewById(R.id.fab)
      //  fab.setImageDrawable(  ContextCompat.getDrawable(activity!!, R.drawable.ic_download))

        return v
    }
}