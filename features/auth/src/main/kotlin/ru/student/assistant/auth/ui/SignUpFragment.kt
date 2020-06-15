package ru.student.assistant.auth.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fr_sign_up.*
import ru.student.assistant.auth.R
import ru.student.assistant.auth.util.isValidEmail
import ru.student.assistant.auth.util.isValidPass
import ru.student.assistant.auth.viewmodel.AuthSingUpModel
import ru.student.assistant.auth.viewmodel.AuthState
import ru.student.assistant.auth.viewmodel.AuthState.SIGN_UP
import ru.student.assistant.auth.viewmodel.AuthViewModel

class SignUpFragment : Fragment() {
    val state: AuthState = SIGN_UP
    private lateinit var viewModel: AuthSingUpModel
    private lateinit var authModel: AuthViewModel

    private var isValid = false

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, group, state)
        viewModel = ViewModelProvider(this)[AuthSingUpModel::class.java]
        authModel = ViewModelProvider(this)[AuthViewModel::class.java]
        return inflater.inflate(R.layout.fr_sign_up, group, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isValid = (edLogin.isValidEmail() && edPass.isValidPass(edPass2))
        viewModel.setValidForm(isValid)
        viewModel.observeForm(this, Observer { authModel.setEnableAction(isValid) })

        checkLicense.setOnCheckedChangeListener { _, isChecked ->
            isValid = (edPass.isValidPass(edPass2) && edLogin.isValidEmail() && isChecked)

            viewModel.setValidForm(isValid)
            authModel.setEnableAction(isValid)
        }

        arrayOf(edLogin, edPass, edPass2).forEach {
            it.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(a: CharSequence?, b: Int, c: Int, d: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    if (it == edLogin) edLogin.isValidEmail() else edPass.isValidPass(edPass2)
                    viewModel.setValidForm(isValid)
                    authModel.setEnableAction(isValid && (authModel.getState() == SIGN_UP))
                    updateSignInData()
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