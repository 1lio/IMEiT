package ru.student.assistant.auth.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fr_sign_in.*
import ru.student.assistant.auth.R
import ru.student.assistant.auth.extensions.BaseTextWatcher
import ru.student.assistant.auth.extensions.isValidEmail
import ru.student.assistant.auth.extensions.isValidPass
import ru.student.assistant.auth.viewmodel.AuthViewModel
import ru.student.assistant.auth.viewmodel.SignInViewModel
import ru.student.assistant.auth.viewmodel.enums.AuthState

class SignInFragment : Fragment(R.layout.fr_sign_in) {

    private var isValid = false

    private lateinit var viewModel: SignInViewModel
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SignInViewModel::class.java]
        authViewModel = ViewModelProvider(activity!!)[AuthViewModel::class.java]

    }

    override fun onViewCreated(view: View, instance: Bundle?) {
        super.onViewCreated(view, instance)

        isValid = (edSignEmail.isValidEmail() && edSignPass.isValidPass())
        viewModel.setValidForm(isValid)

        viewModel.observeForm(this, { authViewModel.setEnableAction(isValid) })

        authRestore.setOnClickListener {

            val frame: AppBarLayout = activity!!.findViewById(R.id.authAppBarLayout)
            frame.visibility = View.INVISIBLE

            val fm = activity!!.supportFragmentManager
            fm.beginTransaction().replace(R.id.frameLayout, RestoreFragment()).commit()
        }

        // authViewModel.observeEmail(this, Observer { edSignEmail.setText(it) })

        edSignEmail.setText(authViewModel.getEmail())

        listOf(edSignEmail, edSignPass).forEach {

            it.addTextChangedListener(object : BaseTextWatcher() {
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (it == edSignEmail) edSignEmail.isValidEmail() else edSignPass.isValidPass()
                    isValid = (edSignEmail.isValidEmail() && edSignPass.isValidPass())
                    viewModel.setValidForm(isValid)
                    authViewModel.setEnableAction(isValid)
                }
            })

        }

        authViewModel.observeTap(activity!!, {
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
        //     authViewModel.setTap(false)
    }
}