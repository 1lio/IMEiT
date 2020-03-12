package ru.suhov.student.features.auth

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.v_sign_up.*

import ru.suhov.student.features.viewmodel.AuthSingUpModel
import ru.suhov.student.R
import ru.suhov.student.core.util.isValidEmail
import ru.suhov.student.core.util.isValidPass
import ru.suhov.student.features.viewmodel.AuthState


class SignUpFragment : BaseAuthFragment() {

    override val state: AuthState = AuthState.SIGN_UP
    private lateinit var viewModel: AuthSingUpModel

    private var isValid = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        viewModel = ViewModelProvider(this)[AuthSingUpModel::class.java]
        return inflater.inflate(R.layout.fr_sign_up, container, false)
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

                    if (it == edLogin)  edLogin.isValidEmail() else edPass.isValidPass(edPass2)
                    viewModel.setValidForm(isValid)
                    authModel.setEnableAction(isValid && (authModel.getState() == AuthState.SIGN_UP))
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