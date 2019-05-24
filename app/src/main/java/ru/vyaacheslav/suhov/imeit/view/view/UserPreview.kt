package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.LocalRepository

class UserPreview : RelativeLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    private var userIcon: Drawable? = null
    private var userName: String? = null
    private var userGroup: String? = null

    private val repository = LocalRepository().getInstance()
    private val exit: View? = null

    init {

        LayoutInflater.from(context).inflate(R.layout.v_user_prevview, this)

      userName = repository.userName
        userGroup = "${repository.faculty}|${repository.group}"

    }

}