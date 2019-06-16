package ru.vyaacheslav.suhov.imeit.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import ru.vyaacheslav.suhov.imeit.view.MainActivity
import ru.vyaacheslav.suhov.imeit.viewmodel.AuthViewModel
import ru.vyaacheslav.suhov.imeit.viewmodel.ControlViewModel

/** Базовый фрагмент для работы с авторизацией */
abstract class BaseLoginFragment : Fragment() {

    lateinit var accountModel: AuthViewModel
    lateinit var controlModel: ControlViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val activity = context as MainActivity
        accountModel = ViewModelProviders.of(activity)[AuthViewModel::class.java]
        controlModel = ViewModelProviders.of(activity)[ControlViewModel::class.java]

        if (accountModel.isSigned()) accountModel.signIn()
    }
}