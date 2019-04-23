package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.time_view.view.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.MainActivity
import ru.vyaacheslav.suhov.imeit.viewmodel.CallTimeViewModel

class TimeView : LinearLayout {

    private val activity = context as MainActivity
    private val viewModel = ViewModelProviders.of(activity)[CallTimeViewModel::class.java]

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    init {

        LayoutInflater.from(context).inflate(R.layout.time_view, this)

        viewModel.observePairStatus(activity, Observer { pair_status.text = it })
        viewModel.observeTimeLeft(activity, Observer { text_time.text = it })
        viewModel.observeCurrentTime(activity, Observer { current_time.text = it })
    }
}