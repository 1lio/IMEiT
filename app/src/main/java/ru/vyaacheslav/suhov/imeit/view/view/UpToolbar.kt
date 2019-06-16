package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.MainActivity
import ru.vyaacheslav.suhov.imeit.viewmodel.ActivityViewModel

class UpToolbar(context: Context, attr: AttributeSet) : Toolbar(context, attr) {

    private val activity = context as MainActivity
    private val model = ViewModelProviders.of(activity)[ActivityViewModel::class.java]

    init {
        // Инициализируем свойства Toolbar
        setTitleTextAppearance(activity, R.style.ToolbarTitleAppearance)
        setSubtitleTextAppearance(activity, R.style.ToolbarSubtitleAppearance)
        setTitleTextColor(ContextCompat.getColor(activity, R.color.white))
        setSubtitleTextColor(ContextCompat.getColor(activity, R.color.grayLight))
        setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimary))

        // Добавляем observer на Title и Subtitle
        model.observeTitle(activity, Observer { title = it })
        model.observeSubtitle(activity, Observer { subtitle = it })
    }
}