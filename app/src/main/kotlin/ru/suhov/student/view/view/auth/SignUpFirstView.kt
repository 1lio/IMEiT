package ru.suhov.student.view.view.auth

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.v_sign_up.view.*
import ru.suhov.student.R
import ru.suhov.student.view.MainActivity
import ru.suhov.student.viewmodel.AuthViewModel
import ru.suhov.student.viewmodel.view.SignUpFirstStepModel

/** View с первым шагом регистрации*/
class SignUpFirstView : ConstraintLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    private val activity = context as MainActivity
    private val model = ViewModelProvider(activity)[SignUpFirstStepModel::class.java]
    private val authModel = ViewModelProvider(activity)[AuthViewModel::class.java]

    init {
        LayoutInflater.from(context).inflate(R.layout.v_sign_up, this)
   //     model.observeValidAll(activity, Observer { btn_next_u.isEnabled = it })

    /*    arrayOf(ed_email_u, ed_pass_u, ed_pass_u_re).forEach {
            it.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (it == ed_email_u) validateEmail() else validatePass()
                    model.setValidAll(validatePass() && validateEmail())
                    updateSignInData()
                }
            })
        }*/
    }

    private fun updateSignInData() {
    /*    val email = ed_email_u.text.toString()
        val pass = ed_pass_u.text.toString()

        authModel.setSignUpLogin(email, pass)*/
    }


}