package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.v_user_preview.view.*
import ru.vyaacheslav.suhov.imeit.MainActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.LocalRepository
import ru.vyaacheslav.suhov.imeit.viewmodel.UserModel

class UserHeader : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    private var title: String? = null
    private var subTitle: String? = null

    private val activity = context as MainActivity
    private val model = ViewModelProviders.of(activity)[UserModel::class.java]
    private val repository = LocalRepository().getInstance()

    init {
        LayoutInflater.from(context).inflate(R.layout.v_user_preview, this)
        val user = model.getUser()

        title = user.name
        subTitle = "${user.faculty}|${user.group}"

        u_name.text = title
        u_group.text = subTitle

        exit.setOnClickListener {
            repository.isAuth = false
            activity.startActivity(Intent(activity, MainActivity::class.java))
            activity.finish()
        }
    }

}