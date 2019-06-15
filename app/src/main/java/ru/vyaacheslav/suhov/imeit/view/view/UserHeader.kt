package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.v_user_preview.view.*
import ru.vyaacheslav.suhov.imeit.view.MainActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.viewmodel.AuthViewModel

class UserHeader : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    private var title: String? = null
    private var subTitle: String? = null

    private val activity = context as MainActivity
    private val model = ViewModelProviders.of(activity)[AuthViewModel::class.java]

    init {

        LayoutInflater.from(context).inflate(R.layout.v_user_preview, this)

        model.observeUser(activity, Observer {
            title = it.name
            subTitle = "${it.faculty}|${it.group}"
        })

        u_name.text = title
        u_group.text = subTitle

        exit.setOnClickListener { model.signOut() }
    }
}