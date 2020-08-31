package ru.student.assistant.auth.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fr_sign_in.*
import ru.student.assistant.auth.R
import ru.student.assistant.auth.extensions.isValidEmail
import ru.student.assistant.auth.extensions.isValidPass
import ru.student.assistant.auth.viewmodel.AuthViewModel
import ru.student.assistant.auth.viewmodel.SignInViewModel
import ru.student.core.AppConstants.FRAGMENT_RESTORE
import ru.student.core.AppConstants.FRAGMENT_SIGN_IN
import ru.student.core.base.BaseFragment
import ru.student.core.base.BaseTextWatcher

class SignInFragment : BaseFragment(R.layout.fr_sign_in) {

    override val state: Byte = FRAGMENT_SIGN_IN

    private lateinit var viewModel: SignInViewModel
    private lateinit var authViewModel: AuthViewModel

    private var isValid = false

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

            val frame: AppBarLayout = requireActivity().findViewById(R.id.authAppBarLayout)
            frame.visibility = View.INVISIBLE

            mainActivity!!.pushFragmentById(FRAGMENT_RESTORE, R.id.frameLayout)
        }

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
    }
}