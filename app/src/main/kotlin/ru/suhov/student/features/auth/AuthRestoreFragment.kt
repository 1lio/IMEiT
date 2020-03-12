package ru.suhov.student.features.auth

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fr_restore.*
import ru.suhov.student.R
import ru.suhov.student.core.util.isValidEmail
import ru.suhov.student.features.viewmodel.AuthRestoreViewModel
import ru.suhov.student.features.viewmodel.AuthState

class AuthRestoreFragment(private val fm: FragmentManager) : BaseAuthFragment() {

    override val state: AuthState = AuthState.RESTORE

    private lateinit var viewModel: AuthRestoreViewModel

    private var isValid = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        viewModel = ViewModelProvider(this)[AuthRestoreViewModel::class.java]
        return inflater.inflate(R.layout.fr_restore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isValid =  edRestore.isValidEmail()
        viewModel.setValidForm(isValid)

        viewModel.observeForm(this, Observer {
            authModel.setEnableAction(edRestore.isValidEmail())
        })

        back.setOnClickListener {

            val frame: AppBarLayout = activity!!.findViewById(R.id.authAppBarLayout)

            frame.visibility = View.VISIBLE
            authModel.setActionName(resources.getString(R.string.sign_in))

            fm.beginTransaction().remove(this).commit()

            authModel.setState(AuthState.SIGN_IN)
        }

        edRestore.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(edRestore.text.toString()).matches()) {
                    edRestore.error = resources.getString(R.string.incorrect_email)
                }

                isValid = edRestore.isValidEmail()
                viewModel.setValidForm(isValid)
                authModel.setEnableAction(isValid && (authModel.getState() == AuthState.RESTORE))

            }
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.setValidForm(isValid)
    }
}