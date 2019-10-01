package ru.vyaacheslav.suhov.imeit.view.view.auth

import android.content.Context
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.v_sign_in.view.*
import ru.vyaacheslav.suhov.imeit.view.MainActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.util.gone
import ru.vyaacheslav.suhov.imeit.util.visible
import ru.vyaacheslav.suhov.imeit.viewmodel.AuthViewModel
import ru.vyaacheslav.suhov.imeit.viewmodel.view.SignInViewModel

/** View авторизации*/
class SignInView : LinearLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    private val activity = context as MainActivity
    private val model = ViewModelProviders.of(activity)[SignInViewModel::class.java]
    private val authModel = ViewModelProviders.of(activity)[AuthViewModel::class.java]

    init {
        LayoutInflater.from(context).inflate(R.layout.v_sign_in, this@SignInView)

        model.observeForms(activity, Observer { btn_sign_in.isEnabled = it }) // Доступность кнопки логин
        authModel.observeTryAuth(activity, Observer { showDialog(it) })   // Попытка авторизации

        arrayOf(ed_email, ed_pass).forEach {
            it.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    model.setEnabledAll(validateForm())

                    val email = ed_email.text.toString()
                    val pass = ed_pass.text.toString()
                    authModel.setSignInLogin(email, pass)
                }

            })
        }
    }

    private fun showDialog(show: Boolean) {
        val views = arrayOf(layout_email, layout_pass, btn_sign_in, btn_sign_up)

/*        if (show) {
            progressBar.visible()
            views.forEach { it.gone() }
        } else {
            progressBar.gone()
            views.forEach { it.visible() }
        }*/
    }

    private fun validateForm(): Boolean {

        return when {
            TextUtils.isEmpty(ed_email.text.toString()) -> {
                ed_email.error = resources.getString(R.string.is_not_empty)
                false
            }

            !android.util.Patterns.EMAIL_ADDRESS.matcher(ed_email.text.toString()).matches() -> {
                ed_email.error = resources.getString(R.string.is_never_email)
                false
            }

            TextUtils.isEmpty(ed_pass.text.toString()) -> {
                ed_pass.error = resources.getString(R.string.is_not_empty)
                false
            }

            else -> {
                ed_email.error = null
                ed_pass.error = null
                true
            }
        }
    }
}