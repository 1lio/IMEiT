package ru.vyaacheslav.suhov.imeit.view.ftagments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.base.BaseLoginFragment
import ru.vyaacheslav.suhov.imeit.util.pushFragment
import ru.vyaacheslav.suhov.imeit.view.view.auth.SignUpFirstView

class SignUpFirstStepFragment : BaseLoginFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = SignUpFirstView(context!!)

        val btnNext: Button = v.findViewById(R.id.btn_next_u)
        val btnCancel: Button = v.findViewById(R.id.cancel)

        val pass = v.findViewById<TextInputEditText>(R.id.ed_pass_u)
        val email = v.findViewById<TextInputEditText>(R.id.ed_email_u)

        btnNext.setOnClickListener {

            val p = pass.text.toString()
            val e = email.text.toString()

            loginViewModel.setUserLogin(e, p)
            fragmentManager!!.beginTransaction().replace(R.id.container, SignUpLastStepFragment()).commit()
        }

        btnCancel.setOnClickListener { FragmentLogin().pushFragment(fragmentManager!!) }
        return v
    }
}