package ru.vyaacheslav.suhov.imeit.view.ftagments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import ru.vyaacheslav.suhov.imeit.MainActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.LocalRepository
import ru.vyaacheslav.suhov.imeit.util.pushFragment
import ru.vyaacheslav.suhov.imeit.util.toast
import ru.vyaacheslav.suhov.imeit.view.ftagments.schedule.SchedulePagerFragment
import ru.vyaacheslav.suhov.imeit.viewmodel.LoginViewModel
import ru.vyaacheslav.suhov.imeit.viewmodel.MainViewModel

class FragmentLogin : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var model: LoginViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        if (LocalRepository().getInstance().isAuth) login(auth.currentUser) else auth.signOut()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fr_sign_in, container, false)

        model = ViewModelProviders.of(context as MainActivity)[LoginViewModel::class.java]

        val singIn: Button = v.findViewById(R.id.sign_in)
        val signUp: View = v.findViewById(R.id.sign_up)

        signUp.setOnClickListener { SignUpFirstStepFragment().pushFragment(fragmentManager!!) }
        singIn.setOnClickListener {

            auth.signInWithEmailAndPassword(model.getEmail(), model.getPass())
                    .addOnCompleteListener {

                        if (it.isSuccessful) {
                            model.login(true)
                            login(auth.currentUser)
                        } else {
                            model.login(false)
                            toast(context!!, R.string.error_sign_in)
                        }
                    }
        }

        return v
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
            model.login(false)
            localRepository.userId = ""
        }
    }
}