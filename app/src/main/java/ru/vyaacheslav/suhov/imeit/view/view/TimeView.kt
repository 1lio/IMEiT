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
import ru.vyaacheslav.suhov.imeit.util.EducationEvent.BREAK
import ru.vyaacheslav.suhov.imeit.util.EducationEvent.END
import ru.vyaacheslav.suhov.imeit.util.EducationEvent.LESSON
import ru.vyaacheslav.suhov.imeit.util.EducationEvent.LUNCH
import ru.vyaacheslav.suhov.imeit.viewmodel.CallTimeViewModel

// View отображающее информацию о текущем времени и остаток времени до конца занятия, перемены и пр.*/
class TimeView : LinearLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    private val activity = context as MainActivity
    private val viewModel = ViewModelProviders.of(activity)[CallTimeViewModel::class.java]

    init {
        LayoutInflater.from(context).inflate(R.layout.v_time_check, this)

        viewModel.observePairStatus(activity, Observer { pair_status.text = getNameCurrentPair(it) })
        viewModel.observeTimeLeft(activity, Observer {

            text_time.text = it
            layout_time_info.contentDescription = "${pair_status.text} $it"

        })
        viewModel.observeCurrentTime(activity, Observer { current_time.text = it })
    }

    private fun getNameCurrentPair(t: Byte): String {

        return when (t) {
            LESSON -> resources.getString(R.string.time_lesson)
            BREAK -> resources.getString(R.string.time_residue)
            LUNCH -> resources.getString(R.string.time_lunch)
            END -> resources.getString(R.string.time_before)
            else -> ""
        }
    }
}