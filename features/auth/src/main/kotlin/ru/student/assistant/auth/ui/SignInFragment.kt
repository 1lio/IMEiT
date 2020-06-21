package ru.student.assistant.auth.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fr_sign_in.*
import ru.student.assistant.auth.R
import ru.student.assistant.auth.extensions.isValidEmail
import ru.student.assistant.auth.extensions.isValidPass
import ru.student.assistant.auth.ui.base.BaseAuthFragment
import ru.student.assistant.auth.viewmodel.AuthViewModel
import ru.student.assistant.auth.viewmodel.SignInViewModel
import ru.student.assistant.auth.viewmodel.enums.AuthState

class SignInFragment : BaseAuthFragment() {

    override val state: AuthState = AuthState.SIGN_IN

    private lateinit var viewModel: SignInViewModel
    private lateinit var authViewModel: AuthViewModel

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, bundle: Bundle?): View? {
        super.onCreateView(inflater, group, bundle)
        viewModel = ViewModelProvider(this)[SignInViewModel::class.java]
        authViewModel = ViewModelProvider(activity!!)[AuthViewModel::class.java]
        return inflater.inflate(R.layout.fr_sign_in, group, false)
    }

    override fun onViewCreated(view: View, instance: Bundle?) {
        super.onViewCreated(view, instance)

        isValid = (edSignEmail.isValidEmail() && edSignPass.isValidPass())
        viewModel.setValidForm(isValid)

        viewModel.observeForm(this, Observer { authViewModel.setEnableAction(isValid) })

        authRestore.setOnClickListener {

            val frame: AppBarLayout = activity!!.findViewById(R.id.authAppBarLayout)
            frame.visibility = View.INVISIBLE

            val fm = activity!!.supportFragmentManager
            fm.beginTransaction().replace(R.id.frameLayout, RestoreFragment()).commit()
        }

        authViewModel.observeEmail(this, Observer { edSignEmail.setText(it) })

        edSignEmail.setText(authViewModel.getEmail())

        listOf(edSignEmail, edSignPass).forEach {

            it.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int, c: Int, a: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    if (it == edSignEmail) edSignEmail.isValidEmail() else edSignPass.isValidPass()

                    isValid = (edSignEmail.isValidEmail() && edSignPass.isValidPass())
                    viewModel.setValidForm(isValid)
                    authViewModel.setEnableAction(isValid)


                }
            })

        }

        authViewModel.observeTap(activity!!, Observer {
            if (it) sendFormData()
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.setValidForm(isValid)
    }

    private fun sendFormData() {
        authViewModel.setEmail(edSignEmail.text.toString())
        authViewModel.setPass(edSignPass.text.toString())
        authViewModel.setTap(false)
    }
}