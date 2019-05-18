package ru.vyaacheslav.suhov.imeit.view.ftagments.calls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.adapters.CallListFragmentAdapter
import ru.vyaacheslav.suhov.imeit.viewmodel.CallSetupViewModel

/** В данном фрагменте мы можем только посмотреть как изменется лист со звонками */
class CallPreviewFragment : Fragment() {

    private lateinit var model: CallSetupViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val v = inflater.inflate(R.layout.fr_recycler, container, false)

        model = ViewModelProviders.of(activity!!)[CallSetupViewModel::class.java]

        val adapter = CallListFragmentAdapter()
        val recycler: RecyclerView = v.findViewById(R.id.recycler)

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.addItemDecoration(DividerItemDecoration(recycler.context, LinearLayoutManager(context).orientation))


       // val pref = Transformations.switchMap(CallSetupViewModel().getPref()){}

        model.observePreviewList(this, Observer { adapter.addAllAndNotify(it) })
        return v
    }
}