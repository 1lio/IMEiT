package ru.student.assistant.calls

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.v_time_check.view.*
import ru.student.assistant.calls.EducationEvent.BREAK
import ru.student.assistant.calls.EducationEvent.LESSON
import ru.student.assistant.calls.EducationEvent.LUNCH
import ru.student.assistant.calls.viewmodel.CallTimeViewModel

// View отображающее информацию о текущем времени и остаток времени до конца занятия...
class TimeView : LinearLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    private val activity = context as AppCompatActivity
    private val viewModel = ViewModelProvider(activity)[CallTimeViewModel::class.java]

    init {
        LayoutInflater.from(context).inflate(R.layout.v_time_check, this)

        viewModel.observePairStatus(activity, { pairStatus.text = getNameCurrentPair(it) })
        viewModel.observeTimeLeft(activity, { textTime.text = it })
    }

    private fun getNameCurrentPair(t: Byte): String {

        return when (t) {
            LESSON -> resources.getString(R.string.time_lesson)
            BREAK -> resources.getString(R.string.time_residue)
            LUNCH -> resources.getString(R.string.time_lunch)
            else -> resources.getString(R.string.time_before)
        }
    }
}