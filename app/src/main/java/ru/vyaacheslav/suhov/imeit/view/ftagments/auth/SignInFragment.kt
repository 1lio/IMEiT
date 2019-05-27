package ru.vyaacheslav.suhov.imeit.view.ftagments.auth

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.viewmodel.MainViewModel

class SignInFragment : Fragment(), View.OnClickListener {

    private lateinit var auth: FirebaseAuth
    private lateinit var singInButton: Button
    private lateinit var fieldEmail: TextInputEditText
    private lateinit var fieldPassword: TextInputEditText
    private lateinit var status: TextView
    private lateinit var model: MainViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fr_sign_in, container, false)
        singInButton = v.findViewById(R.id.btn_sign_in)
        fieldEmail = v.findViewById(R.id.ed_email)
        fieldPassword = v.findViewById(R.id.ed_pass)
        status = v.findViewById(R.id.status)

        model = ViewModelProviders.of(activity!!)[MainViewModel::class.java]

        auth = FirebaseAuth.getInstance()
        updateUI(auth.currentUser)

        singInButton.setOnClickListener(this)
        return v
    }

    override fun onClick(v: View?) {

        when (v!!.id) {

            R.id.btn_sign_in -> signIn(fieldEmail.text.toString(), fieldPassword.text.toString())
        }
    }

    private fun signIn(email: String, password: String) {

        if (!validateForm()) return

        auth.signInWithEmailAndPassword(email, password)

                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Sign in success
                        val user = auth.currentUser
                        updateUI(user)

                        Toast.makeText(context, "Authentication success.",
                                Toast.LENGTH_SHORT).show()

                    } else {
                        // If sign in fails, display a message to the user.

                        Toast.makeText(context, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()

                        updateUI(null)
                    }

                    if (!task.isSuccessful) {
                        // status.setText(R.string.auth_failed)
                    }

                }
    }

    private fun validateForm(): Boolean {
        var valid = true

        val email = fieldEmail.text.toString()
        if (TextUtils.isEmpty(email)) {
            fieldEmail.error = "Required."
            valid = false
        } else {
            fieldEmail.error = null
        }

        val password = fieldPassword.text.toString()
        if (TextUtils.isEmpty(password)) {
            fieldPassword.error = "Required."
            valid = false
        } else {
            fieldPassword.error = null
        }

        return valid
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            model.setSigned(false)
        } else {
            user!!.displayName
            model.setSigned(true)
        }
    }
}