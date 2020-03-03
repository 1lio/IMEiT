package ru.suhov.student.view.view.auth

/*
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.v_user_header.view.*
import ru.suhov.student.R
import ru.suhov.student.view.MainActivity
import ru.suhov.student.viewmodel.AuthViewModel

*/
/** View - Header с минимальной информацией о пользователе*//*

class UserHeader : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    private var title: String? = null
    private var subTitle: String? = null

    private val activity = context as MainActivity
    private val model = ViewModelProvider(activity)[AuthViewModel::class.java]

    init {

        LayoutInflater.from(context).inflate(R.layout.v_user_header, this)

        model.observeUser(activity, Observer {
            title = it.name
            subTitle = "${it.faculty}|${it.group}"
        })

        uName.text = title
        uGroup.text = subTitle

        exit.setOnClickListener { model.signOut() }
    }
}*/
