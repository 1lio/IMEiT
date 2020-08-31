package ru.student.assistant.auth.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fr_restore.*
import ru.student.assistant.auth.R
import ru.student.assistant.auth.extensions.BaseTextWatcher
import ru.student.assistant.auth.extensions.isValidEmail
import ru.student.assistant.auth.viewmodel.AuthViewModel
import ru.student.assistant.auth.viewmodel.RestoreViewModel
import ru.student.core.AppConstants.FRAGMENT_RESTORE
import ru.student.core.AppConstants.FRAGMENT_SIGN_IN
import ru.student.core.base.BaseFragment

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

        viewModel.observeForm(this, {
            authModel.setEnableAction(edRestore.isValidEmail())
        })

        back.setOnClickListener {

            val frame: AppBarLayout = activity!!.findViewById(R.id.authAppBarLayout)

            frame.visibility = View.VISIBLE
            authModel.setActionName(resources.getString(R.string.sign_in))

            activity!!.supportFragmentManager.beginTransaction().remove(this).commit()

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
    }

    private fun checkForm(text: String) =
        !android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches()

    override fun onResume() {
        super.onResume()
        viewModel.setValidForm(isValid)
    }

}