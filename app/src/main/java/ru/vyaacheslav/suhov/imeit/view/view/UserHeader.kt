package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.v_user_preview.view.*
import ru.vyaacheslav.suhov.imeit.MainActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.LocalRepository

class UserHeader : FrameLayout {

    constructor(context: Context):super(context)
    constructor(context: Context, attr: AttributeSet):super(context,attr)

    private var userName: String? = null
    private var userGroup: String? = null

    private val activity = context as MainActivity
    private val repository = LocalRepository().getInstance()

    init {

        LayoutInflater.from(context).inflate(R.layout.v_user_preview, this)

        userName = repository.userId
        userGroup = "${repository.faculty}|${repository.group}"

        u_name.text = userName
        u_group.text = userGroup

        exit.setOnClickListener {
            repository.isAuth = false
            activity.startActivity(Intent(activity, MainActivity::class.java))
            activity.finish()
        }
    }

}