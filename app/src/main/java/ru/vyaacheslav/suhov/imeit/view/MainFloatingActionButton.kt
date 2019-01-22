package ru.vyaacheslav.suhov.imeit.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.design.widget.FloatingActionButton
import android.util.AttributeSet
import ru.vyaacheslav.suhov.imeit.activity.MainActivity
import ru.vyaacheslav.suhov.imeit.viewModel.ModelFloatingActionButton

class MainFloatingActionButton : FloatingActionButton {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    init {
        val activity = context as MainActivity
        val viewModel = ViewModelProviders.of(activity).get(ModelFloatingActionButton::class.java)

        viewModel.observeVisibilityFAB(activity, Observer {
            /// Во всех фрагментах кроме главного скрывать
            activity.supportFragmentManager
        })

    }
}