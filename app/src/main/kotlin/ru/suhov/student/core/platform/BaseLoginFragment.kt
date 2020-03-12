package ru.suhov.student.core.platform

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.suhov.student.features.viewmodel.AuthViewModel
import ru.suhov.student.features.viewmodel.ControlViewModel

abstract class BaseLoginFragment : Fragment() {

    lateinit var accountModel: AuthViewModel
    lateinit var controlModel: ControlViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        accountModel = ViewModelProvider(activity!!)[AuthViewModel::class.java]
        controlModel = ViewModelProvider(activity!!)[ControlViewModel::class.java]

        //if (accountModel.isSigned()) accountModel.signIn()
    }
}