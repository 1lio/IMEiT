package ru.vyaacheslav.suhov.imeit.view.view.auth

import android.content.Context
import android.util.AttributeSet
import android.widget.ListView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ru.vyaacheslav.suhov.imeit.MainActivity
import ru.vyaacheslav.suhov.imeit.viewmodel.view.SignUpLastStepModel

class SignUpLastView(context: Context,attr:AttributeSet) : ListView(context,attr) {

    private val activity = context as MainActivity
    private val model = ViewModelProviders.of(activity)[SignUpLastStepModel::class.java]

    init {

        model.observeGroup(activity, Observer {  })

    }
}