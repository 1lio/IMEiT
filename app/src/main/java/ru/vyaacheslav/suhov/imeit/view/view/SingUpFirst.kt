package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.v_sign_up.view.*
import ru.vyaacheslav.suhov.imeit.LoginActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.viewmodel.view.SignUpFirstStepModel

class SingUpFirst(context: Context, attr: AttributeSet) : ConstraintLayout(context, attr) {

    private val activity = context as LoginActivity
    private val model = ViewModelProviders.of(activity)[SignUpFirstStepModel::class.java]

    init {
        LayoutInflater.from(context).inflate(R.layout.v_sign_up, this)

        model.observeValidAll(activity, Observer { isEnabledNext(it) })

        arrayOf(ed_email_u, ed_pass_u, ed_re_pass).forEach {
            it.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (it == ed_email_u) validateEmail() else validatePass()
                    model.setValidAll(validatePass() && validateEmail())
                }
            })

        }
    }

    private fun validateEmail(): Boolean {

        return when {

            ed_email_u.text.toString().isEmpty() -> {
                ed_email_u.error = resources.getString(R.string.is_empty)
                false
            }

            !android.util.Patterns.EMAIL_ADDRESS.matcher(ed_email_u.text.toString()).matches() -> {
                ed_email_u.error = resources.getString(R.string.is_never_email)
                false
            }

            else -> {
                ed_email_u.error = null
                true
            }
        }

    }

    private fun validatePass(): Boolean {

        return when {

            ed_pass_u.text.toString().isEmpty() -> {
                ed_pass_u.error = resources.getString(R.string.is_empty)
                false
            }

            ed_pass_u.text.toString() != ed_re_pass.text.toString() -> {
                ed_re_pass.error = resources.getString(R.string.pass_do_not_match)
                false
            }

            else -> {
                ed_pass_u.error = null
                ed_re_pass.error = null
                true
            }
        }

    }

    private fun isEnabledNext(enabled: Boolean) {

        btn_next_u.isEnabled = enabled

        if (enabled) {
            btn_next_u.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
            btn_next_u.setTextColor(ContextCompat.getColor(context, R.color.white))
        } else {
            btn_next_u.setBackgroundColor(ContextCompat.getColor(context, R.color.grayLight))
            btn_next_u.setTextColor(ContextCompat.getColor(context, R.color.gray))
        }

    }
}