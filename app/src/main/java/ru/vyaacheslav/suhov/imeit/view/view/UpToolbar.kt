package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.MainActivity
import ru.vyaacheslav.suhov.imeit.viewmodel.MainViewModel

class UpToolbar : Toolbar {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    private val activity = context as MainActivity
    private val model = ViewModelProviders.of(activity)[MainViewModel::class.java]

    init {
        // Инициализируем свойства Toolbar
        this@UpToolbar.setTitleTextAppearance(activity, R.style.ToolbarTitleAppearance)              // Параемтры Title
        this@UpToolbar.setSubtitleTextAppearance(activity, R.style.ToolbarSubtitleAppearance)        // Параметры SubTitle
        this@UpToolbar.setTitleTextColor(ContextCompat.getColor(activity, R.color.white))            // Цвет Title
        this@UpToolbar.setSubtitleTextColor(ContextCompat.getColor(activity, R.color.grayLight))   // Цвет SubTile
        this@UpToolbar.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimary))    // Цвет Toolbar

        // Добавляем observer на Title и Subtitle
        model.observeTitle(activity, Observer { title = it })                         // Обсервер на Title
        model.observeSubtitle(activity, Observer { subtitle = it })                   // Обсервер на SubTitle
    }
}