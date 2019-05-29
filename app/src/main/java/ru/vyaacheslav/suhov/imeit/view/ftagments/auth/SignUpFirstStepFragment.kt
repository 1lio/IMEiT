package ru.vyaacheslav.suhov.imeit.view.ftagments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText
import ru.vyaacheslav.suhov.imeit.LoginActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.viewmodel.LoginViewModel

class SignUpFirstStepFragment : Fragment() {

    private lateinit var model: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fr_sign_up1, container, false)

        model = ViewModelProviders.of(context as LoginActivity)[LoginViewModel::class.java]

        val btnNext: Button = v.findViewById(R.id.btn_next_u)

        val pass = v.findViewById<TextInputEditText>(R.id.ed_pass_u)
        val email = v.findViewById<TextInputEditText>(R.id.ed_email_u)

        btnNext.setOnClickListener {

            val p = pass.text.toString()
            val e = email.text.toString() // <- Косяк ?!

            model.setUserLogin(e, p)
            fragmentManager!!.beginTransaction().replace(R.id.login_container, SingUpLastStepFragment()).commit()
        }

        return v
    }
}