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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.vyaacheslav.suhov.imeit.MainActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref
import ru.vyaacheslav.suhov.imeit.util.timeFormat
import ru.vyaacheslav.suhov.imeit.util.toast
import ru.vyaacheslav.suhov.imeit.viewmodel.CallSetupViewModel
import java.util.*

class CallSetupFragment : Fragment() {

    private var calendar = Calendar.getInstance()
    private lateinit var model: CallSetupViewModel
    private lateinit var pref: CallPref

    private lateinit var edCount: EditText
    private lateinit var edBreak: EditText
    private lateinit var edLengthLesson: EditText
    private lateinit var edLengthLunch: EditText
    private lateinit var edLengthBreakPair: EditText
    private lateinit var edLunchStart: EditText
    private lateinit var textStart: TextView
    private lateinit var defBtn:Button

    private var startTime: Int = 0
    private var listEditTexts = arrayListOf<EditText>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model = ViewModelProviders.of(this)[CallSetupViewModel::class.java]
        pref = model.getPrefData()
        startTime = pref.start
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val v = inflater.inflate(R.layout.fr_call_setup, container, false)
        initViews(v)

        // заполняем EditText-ы
        setupCurrentPref()

        model.observePref(activity!!, Observer {
            listEditTexts.forEach { if ((it.text.isEmpty())) it.error = "Поле не должно быть пустым" }
        })

        //Смотрим за полями и обновляем liveData
        getDataForEditText()

        // Нажатия
        fabClick()
        defBtnClick()
        timePickerClick()

        return v
    }

    private fun setupCurrentPref() {
        val preferences: CallPref = model.getPrefData()
        listEditTexts.forEach {
            val t = when (it) {
                edCount -> preferences.count.toString()
                edLengthLesson -> preferences.lengthLesson.toString()
                edBreak -> preferences.lengthBreak.toString()
                edLengthLunch -> preferences.lengthLunch.toString()
                edLengthBreakPair -> preferences.lengthBreakPair.toString()
                edLunchStart -> preferences.lunchStart.toString()
                else -> ""
            }
            it.setText(t, TextView.BufferType.EDITABLE)
        }
        textStart.text = pref.start.timeFormat()
    }

    // установка обработчика выбора времени
    private var onTimeSetListener = TimePickerDialog.OnTimeSetListener { _, h, m ->
        calendar.set(Calendar.HOUR_OF_DAY, h)
        calendar.set(Calendar.MINUTE, m)

        startTime = (h * 60 + m)
        textStart.text = pref.start.timeFormat()
    }

    private fun getDataForEditText() {
        // Смотрим за изменениями и публикуем в liveData
        listEditTexts.forEach {
            it.addTextChangedListener(object : TextWatcher {

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    when (it) {
                        edCount -> pref.count = s!!.convertToInt()
                        edLengthLesson -> pref.lengthLesson = s!!.convertToInt()
                        edBreak -> pref.lengthBreak = s!!.convertToInt()
                        edLengthLunch -> pref.lengthLunch = s!!.convertToInt()
                        edLengthBreakPair -> pref.lengthBreakPair = s!!.convertToInt()
                        edLunchStart -> pref.lunchStart = s!!.convertToInt()
                    }
                    pref.start = startTime
                    model.setPref(pref)
                }

                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            })
        }
    }

    // Обработка Fab
    private fun fabClick() {
        val activity = context as MainActivity
        val fab: FloatingActionButton = activity.findViewById(R.id.fab)

        fab.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_save))

        fab.setOnClickListener {
            model.saveAndPush()
            toast(activity, R.string.save_settings)
        }
    }

    // Обработка кнопки "стнадарные"
    private fun defBtnClick() {
        defBtn.setOnClickListener {
            model.setDefaultPreferences()
            toast(context!!, R.string.def_settings)
        }
    }

    //TimePicker
    private fun timePickerClick(){
        // отображаем диалоговое окно для выбора времени
        textStart.setOnClickListener {

            TimePickerDialog(
                    activity,
                    onTimeSetListener,
                    pref.start / 60,
                    pref.start % 60, true)
                    .show()
        }
    }

    private fun initViews(v: View) {
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

    // TODO: КОСТЫЛЬ ПЕРЕДЕЛАТЬ!!!
    fun CharSequence.convertToInt(): Int = try {
        this.toString().toInt()
    } catch (e: Exception) {
        0
    }
}