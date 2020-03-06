package ru.suhov.student.view.ftagments.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.suhov.student.viewmodel.AuthState
import ru.suhov.student.viewmodel.AuthViewModel

abstract class BaseAuthFragment : Fragment() {

    lateinit var authModel: AuthViewModel
    abstract val state: AuthState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authModel = ViewModelProvider(activity!!)[AuthViewModel::class.java]
        authModel.setState(state)
    }
}