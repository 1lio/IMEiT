package ru.vyaacheslav.suhov.imeit.view.ftagments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import ru.vyaacheslav.suhov.imeit.MainActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.LocalRepository
import ru.vyaacheslav.suhov.imeit.util.pushFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.schedule.SchedulePagerFragment
import ru.vyaacheslav.suhov.imeit.viewmodel.LoginViewModel
import ru.vyaacheslav.suhov.imeit.viewmodel.MainViewModel
import ru.vyaacheslav.suhov.imeit.viewmodel.view.SignUpLastStepModel

class SignUpLastStepFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    private lateinit var modelLogin: LoginViewModel
    private lateinit var modelLast: SignUpLastStepModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fr_sign_last, container, false)

        auth = FirebaseAuth.getInstance()

        val back: View = v.findViewById(R.id.btn_back)
        val signUp: Button = v.findViewById(R.id.registration)
        val activity = context as MainActivity

        modelLogin = ViewModelProviders.of(activity)[LoginViewModel::class.java]
        modelLast = ViewModelProviders.of(activity)[SignUpLastStepModel::class.java]

        back.setOnClickListener { SignUpFirstStepFragment().pushFragment(fragmentManager!!) }
        signUp.setOnClickListener {

            // Создаем пользователя
            createAccount(modelLogin.getEmail(), modelLogin.getPass())
        }
        return v
    }

    private fun createAccount(email: String, pass: String) {

        auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(context as MainActivity) {

                    if (it.isSuccessful) {

                        // Если все хорошо, создаем учетку пользователя
                        modelLast.createUser(auth.currentUser!!.uid)

                        // и логинемся
                        login(auth.currentUser)
                    } else {
                        // Сообщение об ошибке
                        Toast.makeText(activity, "ERROR", Toast.LENGTH_SHORT).show()
                    }
                }

    }

    private fun login(user: FirebaseUser?) {

        val localRepository = LocalRepository().getInstance()
        val mainModel = ViewModelProviders.of(context as MainActivity)[MainViewModel::class.java]

        if (user != null) {
            mainModel.isAuth = true
            localRepository.isAuth = true
            localRepository.userId = auth.currentUser!!.uid
            SchedulePagerFragment().pushFragment(fragmentManager!!)
        } else {
            localRepository.userId = ""
        }
    }
}