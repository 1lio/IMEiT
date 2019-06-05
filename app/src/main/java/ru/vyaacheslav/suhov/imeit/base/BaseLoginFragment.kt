package ru.vyaacheslav.suhov.imeit.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import ru.vyaacheslav.suhov.imeit.MainActivity
import ru.vyaacheslav.suhov.imeit.repository.LocalRepository
import ru.vyaacheslav.suhov.imeit.util.ErrorEvent.ERROR_CREATE_ACCOUNT
import ru.vyaacheslav.suhov.imeit.util.ErrorEvent.ERROR_LOGIN
import ru.vyaacheslav.suhov.imeit.viewmodel.LoginViewModel
import ru.vyaacheslav.suhov.imeit.viewmodel.MainViewModel
import ru.vyaacheslav.suhov.imeit.viewmodel.view.SignUpLastStepModel

abstract class BaseLoginFragment : BaseFragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var activity: AppCompatActivity
    private lateinit var mainModel: MainViewModel

    lateinit var modelLast: SignUpLastStepModel
    lateinit var loginViewModel: LoginViewModel

    private val localRepository = LocalRepository().getInstance()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        activity = context as MainActivity

        mainModel = ViewModelProviders.of(activity)[MainViewModel::class.java]
        loginViewModel = ViewModelProviders.of(activity)[LoginViewModel::class.java]
        modelLast = ViewModelProviders.of(activity)[SignUpLastStepModel::class.java]

        if (localRepository.isAuth) login(auth.currentUser) else auth.signOut()

        loginViewModel.observeLogin(activity, Observer {
            if (it) {
                auth.signInWithEmailAndPassword(loginViewModel.getEmail(), loginViewModel.getPass())
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                loginViewModel.login(true)
                                mainModel.setFirstRun(true)
                                login(auth.currentUser)
                            } else {
                                loginViewModel.login(false)
                                mainModel.setErrorMsg(ERROR_LOGIN)
                            }
                        }
            }
        })

    }

    private fun login(user: FirebaseUser?) {

        if (user != null) {
            mainModel.isAuth = true
            localRepository.userId = auth.currentUser!!.uid
        } else {
            loginViewModel.login(false)
            mainModel.setErrorMsg(ERROR_LOGIN)
        }
    }

    fun createAccount(email: String, pass: String) {

        auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(context as MainActivity) {

                    if (it.isSuccessful) {
                        // Если все хорошо, создаем учетку пользователя
                        modelLast.createUser(auth.currentUser!!.uid)
                        // и логинемся
                        login(auth.currentUser)
                        mainModel.setFirstRun(true)
                    } else {
                        // Сообщение об ошибке
                        mainModel.setErrorMsg(ERROR_CREATE_ACCOUNT)
                    }
                }

    }
}