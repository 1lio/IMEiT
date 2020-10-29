package ru.student.assistant.auth.ui

import android.os.Bundle
import android.util.Patterns.EMAIL_ADDRESS
import android.view.KeyEvent
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fr_restore.*
import ru.student.assistant.auth.R
import ru.student.assistant.auth.extensions.isValidEmail
import ru.student.assistant.auth.viewmodel.AuthViewModel
import ru.student.assistant.auth.viewmodel.RestoreViewModel
import ru.student.assistant.core.AppConstants.FRAGMENT_RESTORE
import ru.student.assistant.core.AppConstants.FRAGMENT_SIGN_IN
import ru.student.assistant.core.base.BaseFragment
import ru.student.assistant.core.base.BaseTextWatcher
import ru.student.assistant.core.ext.showToast

class RestoreFragment : BaseFragment(R.layout.fr_restore) {

    override var state: Byte = FRAGMENT_RESTORE

    private lateinit var authModel: AuthViewModel
    private lateinit var viewModel: RestoreViewModel

    private var isValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authModel = ViewModelProvider(activity!!)[AuthViewModel::class.java]
        viewModel = ViewModelProvider(activity!!)[RestoreViewModel::class.java]

        authModel.setState(state)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isValid = edRestore.isValidEmail()
        viewModel.setValidForm(isValid)

        viewModel.observeForm(this, { authModel.setEnableAction(edRestore.isValidEmail()) })

        back.setOnClickListener {

            val frame: View = requireActivity().findViewById(R.id.authAppBarLayout)

            frame.visibility = View.VISIBLE
            authModel.setActionName(resources.getString(R.string.sign_in))

            mainActivity!!.removeFragmentById(FRAGMENT_RESTORE)
            authModel.setState(FRAGMENT_SIGN_IN)
        }

        edRestore.setText(authModel.getEmail())

        edRestore.addTextChangedListener(object : BaseTextWatcher() {

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (checkForm(edRestore.text.toString())) edRestore.error =
                    resources.getString(R.string.incorrect_email)

                isValid = edRestore.isValidEmail()
                viewModel.setValidForm(isValid)
                authModel.setEnableAction(isValid && (authModel.getState() == FRAGMENT_RESTORE))
                authModel.setEmail(edRestore.text.toString())
            }
        })


        // edRestore.setImeActionLabel("SEND", KeyEvent.KEYCODE_ENTER)
        edRestore.setOnKeyListener { _, i, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                showToast("RESTORE!")
                return@setOnKeyListener true
            }

            return@setOnKeyListener false
        }
    }


    private fun checkForm(text: String) = !EMAIL_ADDRESS.matcher(text).matches()

    override fun onResume() {
        super.onResume()
        viewModel.setValidForm(isValid)
    }

}