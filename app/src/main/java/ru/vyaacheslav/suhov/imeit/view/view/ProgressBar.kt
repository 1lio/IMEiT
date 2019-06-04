package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.v_progress.view.*
import ru.vyaacheslav.suhov.imeit.MainActivity
import ru.vyaacheslav.suhov.imeit.viewmodel.view.ProgressBarViewModel

class ProgressBar : LinearLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    private val activity = context as MainActivity
    private val model = ViewModelProviders.of(activity)[ProgressBarViewModel::class.java]

    init {
        model.observeVisibility(activity, Observer { visibility = if (it) View.VISIBLE else View.GONE })
        model.observeTextProgress(activity, Observer { textProgress.text = it })
        model.observeProgress(activity, Observer {  })
    }
}