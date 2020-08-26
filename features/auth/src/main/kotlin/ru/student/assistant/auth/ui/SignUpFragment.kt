package ru.student.assistant.auth.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fr_sign_up.*
import ru.student.assistant.auth.R
import ru.student.assistant.auth.extensions.BaseTextWatcher
import ru.student.assistant.auth.extensions.isValidEmail
import ru.student.assistant.auth.extensions.isValidPass
import ru.student.assistant.auth.viewmodel.AuthViewModel
import ru.student.assistant.auth.viewmodel.SignUpViewModel
import ru.student.assistant.auth.viewmodel.enums.AuthState

class SignUpFragment : Fragment(R.layout.fr_sign_up) {

    private lateinit var viewModel: SignUpViewModel
    private lateinit var authModel: AuthViewModel

    private var isValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SignUpViewModel::class.java]
        authModel = ViewModelProvider(activity!!)[AuthViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isValid = (edLogin.isValidEmail() && edPass.isValidPass(edPass2))
        viewModel.setValidForm(isValid)
        viewModel.observeForm(this, { authModel.setEnableAction(isValid) })

        checkLicense.setOnCheckedChangeListener { _, isChecked ->
            isValid = (edPass.isValidPass(edPass2) && edLogin.isValidEmail() && isChecked)

            viewModel.setValidForm(isValid)
            authModel.setEnableAction(isValid)
        }

        edLogin.setText(authModel.getEmail())
        arrayOf(edLogin, edPass, edPass2).forEach {
            it.addTextChangedListener(object : BaseTextWatcher() {

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (it == edLogin) edLogin.isValidEmail() else edPass.isValidPass(edPass2)
                    viewModel.setValidForm(isValid)
                    authModel.setEnableAction(isValid && (authModel.getState() == AuthState.SIGN_UP))
                  //  updateSignInData()
                }
            })
        }
    }

    private fun updateSignInData() {
        val email = edLogin.text.toString()
        val pass = edPass.text.toString()

        //viewModel.setSignUpLogin(email, pass)
    }
}