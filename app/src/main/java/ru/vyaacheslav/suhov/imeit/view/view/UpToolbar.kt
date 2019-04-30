package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.MainActivity
import ru.vyaacheslav.suhov.imeit.viewmodel.UpToolbarViewModel

class UpToolbar : Toolbar {

    constructor(context: Context): super(context)
    constructor(context: Context,attr:AttributeSet):super(context,attr)

    private val activity = context as MainActivity                                                  // Приводим переданный context к ContextActivity
    private val viewModel = ViewModelProviders.of(activity)[UpToolbarViewModel::class.java]         // ViewModel данного Toolbar

    init {

        // Инициализируем свойства Toolbar
        this@UpToolbar.setTitleTextAppearance(activity, R.style.ToolbarTitleAppearance)             // Параемтры Title
        this@UpToolbar.setSubtitleTextAppearance(activity, R.style.ToolbarSubtitleAppearance)       // Параметры SubTitle
        this@UpToolbar.setTitleTextColor(ContextCompat.getColor(activity, R.color.white))           // Цвет Title
        this@UpToolbar.setSubtitleTextColor(ContextCompat.getColor(activity, R.color.gray))         // Цвет SubTile
        this@UpToolbar.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimary))   // Цвет Toolbar

        // Добавляем observer на Title и Subtitle
        viewModel.observeNameInstitute(activity, Observer { this@UpToolbar.title = it })            // Обсервер на Title
        viewModel.observeNameGroup(activity, Observer { this@UpToolbar.subtitle = it })             // Обсервер на SubTitle
    }
}