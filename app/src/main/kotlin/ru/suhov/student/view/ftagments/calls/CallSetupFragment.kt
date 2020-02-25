package ru.suhov.student.view.ftagments.calls

import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fr_call_setup.*
import ru.suhov.student.R
import ru.suhov.student.view.MainActivity
import ru.suhov.student.repository.LocalRepository
import ru.suhov.student.entity.CallPref
import ru.suhov.student.util.timeFormat
import ru.suhov.student.util.toast
import ru.suhov.student.viewmodel.CallTimeViewModel
import java.util.*
import kotlin.collections.ArrayList

/** Фрагмент настройки времени звонков */
class CallSetupFragment : Fragment(), View.OnClickListener {

    private lateinit var viewModelSetup: CallTimeViewModel
    private lateinit var pref: CallPref
    private lateinit var fab:FloatingActionButton

    private var listEditTexts = ArrayList<EditText>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val v = inflater.inflate(R.layout.fr_call_setup, container, false)
        viewModelSetup = ViewModelProvider(context as MainActivity)[CallTimeViewModel::class.java]


        // заполняем EditText-ы
        setupCurrentPref()

        //Смотрим за полями и обновляем liveData
        getDataForEditText()

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listEditTexts.addAll(arrayOf(ed_count_call, ed_length_lesson, ed_length_break, ed_length_lunch,
                ed_length_break_pair, ed_lunch_start))

        viewModelSetup.getCurrentPref()

        fab.setOnClickListener(this)
        btn_def_call.setOnClickListener(this)
        time_start.setOnClickListener(this)

        // заполняем EditText-ы
        setupCurrentPref()

        //Смотрим за полями и обновляем liveData
        getDataForEditText()
        fab.show()
    }

    override fun onPause() {
        super.onPause()
        fab.hide()
    }

    override fun onResume() {
        super.onResume()
        fab.show()
    }

    private fun setupCurrentPref() {
        var count = 1 // Ставим счетчик чтобы обсервер не обновл данные когда не нужно

        pref = viewModelSetup.getPrefData() // Получаем данные

        // Устанавливаем значения в поля
        fun setUp(c: CallPref) {

            listEditTexts.forEach {
                when (it) {
                    ed_count_call -> it.setText(c.count.toString())
                    ed_length_lesson -> it.setText(c.lengthLesson.toString(), TextView.BufferType.EDITABLE)
                    ed_length_break -> it.setText(c.lengthBreak.toString())
                    ed_length_lunch -> it.setText(c.lengthLunch.toString())
                    ed_length_break_pair -> it.setText(pref.lengthBreakPair.toString())
                    ed_lunch_start -> it.setText(c.lunchStart.toString())
                }
            }
            time_start.text = pref.start.timeFormat()
        }

        // Наблюдаем за настройками
        viewModelSetup.observeCalls(activity!!, androidx.lifecycle.Observer { c ->
            if (count == 1) setUp(c)
            if (!LocalRepository().isChangedPref) setUp(viewModelSetup.getPrefData())
        })
        count++
    }

    private var onTimeSetListener = TimePickerDialog.OnTimeSetListener { _, h, m ->
        Calendar.getInstance().set(Calendar.HOUR_OF_DAY, h)
        Calendar.getInstance().set(Calendar.MINUTE, m)
        pref.start = (h * 60 + m)
        time_start.text = pref.start.timeFormat()
    }

    private fun getDataForEditText() {
        // Смотрим за изменениями и публикуем в liveData
        listEditTexts.forEach {
            it.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    when (it) {
                        ed_count_call -> if (s.validDateCallPref(it)) pref.count = s.toString().toInt()
                        ed_length_lesson -> if (s.validDateCallPref(it)) pref.lengthBreak = s.toString().toInt()
                        ed_length_break -> if (s.validDateCallPref(it)) pref.lengthLesson = s.toString().toInt()
                        ed_length_lunch -> if (s.validDateCallPref(it)) pref.lengthLunch = s.toString().toInt()
                        ed_length_break_pair -> if (s.validDateCallPref(it)) pref.lengthBreakPair = s.toString().toInt()
                        ed_lunch_start -> if (s.validDateCallPref(it)) pref.lunchStart = s.toString().toInt()
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
                ed.error = resources.getString(R.string.is_empty)
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

            this.toString().toInt() > 10 && ed == ed_count_call -> {
                ed.error = resources.getString(R.string.max_pair)
                false
            }

            this.toString().toInt() > pref.start - 1 && ed == ed_lunch_start -> {
                ed.error = resources.getString(R.string.max2)
                false
            }
            else -> true
        }

        fab.isEnabled = isCorrect
        return isCorrect
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
                toast(context!!, R.string.def_settings)
            }
           /* R.id.fab -> {
                viewModelSetup.saveAndPush(pref)
                toast(activity!!, R.string.save_settings)
            }*/
        }
    }
}