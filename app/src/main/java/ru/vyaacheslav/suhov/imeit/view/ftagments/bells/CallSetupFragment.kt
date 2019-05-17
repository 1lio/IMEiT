package ru.vyaacheslav.suhov.imeit.view.ftagments.bells

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref
import ru.vyaacheslav.suhov.imeit.util.timeFormat
import ru.vyaacheslav.suhov.imeit.viewmodel.CallSetupViewModel

class CallSetupFragment : Fragment() {

    private lateinit var model: CallSetupViewModel
    private val pref = CallPref()
    private lateinit var edCount: EditText
    private lateinit var edBreak: EditText
    private lateinit var edLengthLesson: EditText
    private lateinit var edLengthLunch: EditText
    private lateinit var edLengthBreakPair: EditText
    private lateinit var edLunchStart: EditText
    private lateinit var textStart: TextView

    private var listEditTexts = arrayListOf<EditText>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val v = inflater.inflate(R.layout.fr_call_setup, container, false)

        model = ViewModelProviders.of(this)[CallSetupViewModel::class.java]

        // Тут можно прикуртить DataBinding
        edCount = v.findViewById(R.id.ed_count_call)
        edBreak = v.findViewById(R.id.ed_length_break)
        edLengthLesson = v.findViewById(R.id.ed_length_lesson)
        edLengthLunch = v.findViewById(R.id.ed_length_lunch)
        edLengthBreakPair = v.findViewById(R.id.ed_length_break_pair)
        edLunchStart = v.findViewById(R.id.ed_lunch_start)
        textStart = v.findViewById(R.id.time_start)

        listEditTexts.addAll(arrayOf(edCount, edLengthLesson, edBreak, edLengthLunch, edLengthBreakPair, edLunchStart))

        // азполняем уже имеющимеся значениями
        setupCurrentPref()

        // Смотрим за изменениями и публикуем в liveData

        listEditTexts.forEach {
            it.addTextChangedListener(object : TextWatcher {

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    when (it) {
                        edCount -> pref.count = s.toString().toInt()
                        edLengthLesson -> pref.lengthLesson = s.toString().toInt()
                        edBreak -> pref.lengthBreak = s.toString().toInt()
                        edLengthLunch -> pref.lengthLunch = s.toString().toInt()
                        edLengthBreakPair -> pref.lengthBreakPair = s.toString().toInt()
                        edLunchStart -> pref.lunchStart = s.toString().toInt()
                    }

                }

                override fun afterTextChanged(s: Editable?) {}

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            })
        }
        return v
    }


    private fun setupCurrentPref() {

        val preferences: CallPref = model.getPreferences()
        listEditTexts.forEach {
            it.hint = when (it) {
                edCount -> preferences.count.toString()
                edLengthLesson -> preferences.lengthLesson.toString()
                edBreak -> preferences.lengthBreak.toString()
                edLengthLunch -> preferences.lengthLunch.toString()
                edLengthBreakPair -> preferences.lengthBreakPair.toString()
                edLunchStart -> preferences.lunchStart.toString()
                else -> null
            }
        }
        textStart.text = pref.start.timeFormat()
    }
}