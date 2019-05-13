package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.v_time_check.view.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.MainActivity
import ru.vyaacheslav.suhov.imeit.viewmodel.BellsTimeViewModel

class TimeView : LinearLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    private val activity = context as MainActivity
    private val viewModel = ViewModelProviders.of(activity)[BellsTimeViewModel::class.java]

    init {
        LayoutInflater.from(context).inflate(R.layout.v_time_check, this)

        viewModel.observePairStatus(activity, Observer { pair_status.text = it })
        viewModel.observeTimeLeft(activity, Observer { text_time.text = it })
        viewModel.observeCurrentTime(activity, Observer { current_time.text = it })
    }
}