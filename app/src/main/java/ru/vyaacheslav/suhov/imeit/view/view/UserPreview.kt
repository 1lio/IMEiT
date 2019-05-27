package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.v_user_preview.view.*
import ru.vyaacheslav.suhov.imeit.MainActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.LocalRepository
import ru.vyaacheslav.suhov.imeit.viewmodel.MainViewModel

class UserPreview : RelativeLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    private var userIcon: Drawable? = null
    private var userName: String? = null
    private var userGroup: String? = null

    private val activity = context as MainActivity
    private val model = ViewModelProviders.of(activity)[MainViewModel::class.java]

    private val repository = LocalRepository().getInstance()

    init {
        LayoutInflater.from(context).inflate(R.layout.v_user_preview, this)

        userName = repository.userName
        userGroup = "${repository.faculty}|${repository.group}"

        u_name.text = userName
        u_group.text = userGroup

        exit.setOnClickListener { model.setSigned(false) }
    }

}