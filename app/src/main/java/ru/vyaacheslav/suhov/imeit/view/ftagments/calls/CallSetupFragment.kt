package ru.vyaacheslav.suhov.imeit.view.ftagments.calls

import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.vyaacheslav.suhov.imeit.MainActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref
import ru.vyaacheslav.suhov.imeit.util.timeFormat
import ru.vyaacheslav.suhov.imeit.util.toast
import ru.vyaacheslav.suhov.imeit.viewmodel.CallTimeViewModel
import java.util.*
import kotlin.collections.ArrayList

class CallSetupFragment : Fragment(), View.OnClickListener {
    private lateinit var viewModelSetup: CallTimeViewModel

    private lateinit var pref: CallPref // установки которые получаем
    private lateinit var edCount: EditText

    private lateinit var edBreak: EditText
    private lateinit var edLengthLesson: EditText
    private lateinit var edLengthLunch: EditText
    private lateinit var edLengthBreakPair: EditText
    private lateinit var edLunchStart: EditText
    private lateinit var textStart: TextView
    private lateinit var defBtn: Button
    private lateinit var fab: FloatingActionButton

    private var listEditTexts = ArrayList<EditText>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val v = inflater.inflate(R.layout.fr_call_setup, container, false)
        initViews(v)

        // заполняем EditText-ы
        setupCurrentPref()

        //Смотрим за полями и обновляем liveData
        getDataForEditText()

        fab.setOnClickListener(this)
        defBtn.setOnClickListener(this)
        textStart.setOnClickListener(this)
        return v
    }

    private fun setupCurrentPref() {
        pref = viewModelSetup.getPrefData()
        listEditTexts.forEach {
            when (it) {
                edCount -> it.setText(pref.count.toString())
                edLengthLesson -> it.setText(pref.lengthLesson.toString(), TextView.BufferType.EDITABLE)
                edBreak -> it.setText(pref.lengthBreak.toString())
                edLengthLunch -> it.setText(pref.lengthLunch.toString())
                edLengthBreakPair -> it.setText(pref.lengthBreakPair.toString())
                edLunchStart -> it.setText(pref.lunchStart.toString())

            }
        }
        textStart.text = pref.start.timeFormat()
    }

    private var onTimeSetListener = TimePickerDialog.OnTimeSetListener { _, h, m ->
        Calendar.getInstance().set(Calendar.HOUR_OF_DAY, h)
        Calendar.getInstance().set(Calendar.MINUTE, m)
        pref.start = (h * 60 + m)
        textStart.text = pref.start.timeFormat()
    }

    private fun getDataForEditText() {
        // Смотрим за изменениями и публикуем в liveData
        listEditTexts.forEach {
            it.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    when (it) {
                        edCount -> if (s.validDateCallPref(it)) pref.count = s.toString().toInt()
                        edBreak -> if (s.validDateCallPref(it)) pref.lengthBreak = s.toString().toInt()
                        edLengthLesson -> if (s.validDateCallPref(it)) pref.lengthLesson = s.toString().toInt()
                        edLengthLunch -> if (s.validDateCallPref(it)) pref.lengthLunch = s.toString().toInt()
                        edLengthBreakPair -> if (s.validDateCallPref(it)) pref.lengthBreakPair = s.toString().toInt()
                        edLunchStart -> if (s.validDateCallPref(it)) pref.lunchStart = s.toString().toInt()
                    }
                }

                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            })
        }
    }

    private fun CharSequence.validDateCallPref(ed: EditText): Boolean {

        val isCorrect: Boolean = when {
            this.toString() == "" -> {
                ed.error = resources.getString(R.string.poly_is_empty)
                false
            }

            this.toString().toInt() == 0 -> {
                ed.error = resources.getString(R.string.max_0)
                false
            }
            this.toString().toInt() > 60 -> {
                ed.error = resources.getString(R.string.max_60)
                false
            }

            this.toString().toInt() > 10 && ed == edCount -> {
                ed.error = resources.getString(R.string.max_pair)
                false
            }

            this.toString().toInt() > pref.start - 1 && ed == edLunchStart -> {
                ed.error = resources.getString(R.string.max2)
                false
            }
            else -> true
        }

        fab.isEnabled = isCorrect
        return isCorrect
    }

    private fun initViews(v: View) {
        viewModelSetup = ViewModelProviders.of(context as MainActivity)[CallTimeViewModel::class.java]
        viewModelSetup.getPref()

        fab = activity!!.findViewById(R.id.fab)
        fab.setImageDrawable(ContextCompat.getDrawable(activity!!, R.drawable.ic_save))
        // Можно прикуртить DataBinding
        edCount = v.findViewById(R.id.ed_count_call)
        edBreak = v.findViewById(R.id.ed_length_break)
        edLengthLesson = v.findViewById(R.id.ed_length_lesson)
        edLengthLunch = v.findViewById(R.id.ed_length_lunch)
        edLengthBreakPair = v.findViewById(R.id.ed_length_break_pair)
        edLunchStart = v.findViewById(R.id.ed_lunch_start)
        textStart = v.findViewById(R.id.time_start)
        defBtn = v.findViewById(R.id.btn_def_call)

        listEditTexts.addAll(arrayOf(edCount, edLengthLesson, edBreak, edLengthLunch,
                edLengthBreakPair, edLunchStart))
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.time_start -> {
                TimePickerDialog(
                        activity,
                        onTimeSetListener,
                        pref.start / 60,
                        pref.start % 60,
                        true)
                        .show()
            }
            R.id.btn_def_call -> {
                viewModelSetup.setDefaultPreferences()
                setupCurrentPref() // Без костылей не обошлось
                toast(context!!, R.string.def_settings)
            }
            R.id.fab -> {
                viewModelSetup.saveAndPush(pref)
                toast(activity!!, R.string.save_settings)
            }
        }
    }
}