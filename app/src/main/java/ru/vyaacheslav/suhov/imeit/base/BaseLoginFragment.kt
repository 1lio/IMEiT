package ru.vyaacheslav.suhov.imeit.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.vyaacheslav.suhov.imeit.viewmodel.AuthViewModel
import ru.vyaacheslav.suhov.imeit.viewmodel.ControlViewModel

/** Базовый фрагмент для работы с авторизацией */
abstract class BaseLoginFragment : Fragment() {

    lateinit var accountModel: AuthViewModel
    lateinit var controlModel: ControlViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        accountModel = ViewModelProvider(activity!!)[AuthViewModel::class.java]
        controlModel = ViewModelProvider(activity!!)[ControlViewModel::class.java]

        if (accountModel.isSigned()) accountModel.signIn()
    }
}