package ru.vyaacheslav.suhov.imeit.view.ftagments.auth

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import ru.vyaacheslav.suhov.imeit.MainActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.LocalRepository
import ru.vyaacheslav.suhov.imeit.util.toast
import ru.vyaacheslav.suhov.imeit.LoginActivity
import ru.vyaacheslav.suhov.imeit.viewmodel.LoginViewModel

/** Фрагмент с логином */
class SignInFragment : Fragment(), View.OnClickListener {

    private lateinit var activity: AppCompatActivity
    private lateinit var auth: FirebaseAuth
    private lateinit var model: LoginViewModel

    private lateinit var fieldEmail: TextInputEditText
    private lateinit var fieldPassword: TextInputEditText
    private lateinit var singInButton: Button
    private lateinit var signUp: TextView
    private lateinit var progressBar: ProgressBar

    private lateinit var layoutEmail: TextInputLayout
    private lateinit var layoutPass: TextInputLayout

    private val isSigned = LocalRepository().getInstance().isSinged

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        auth = FirebaseAuth.getInstance()

        // Проверяем входил ли пользователь
        if (isSigned) login(auth.currentUser) else auth.signOut()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fr_sign_in, container, false)

        activity = context as LoginActivity
        model = ViewModelProviders.of(activity)[LoginViewModel::class.java]

        singInButton = v.findViewById(R.id.btn_sign_in)
        fieldEmail = v.findViewById(R.id.ed_email)
        fieldPassword = v.findViewById(R.id.ed_pass)
        signUp = v.findViewById(R.id.sign_up)
        progressBar = v.findViewById(R.id.progressBar)

        layoutPass = v.findViewById(R.id.layout_pass)
        layoutEmail = v.findViewById(R.id.layout_email)

        singInButton.setOnClickListener(this)
        signUp.setOnClickListener(this)
        return v
    }

    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.btn_sign_in -> signIn(fieldEmail.text.toString(), fieldPassword.text.toString())
            R.id.sign_up -> fragmentManager!!.beginTransaction().replace(R.id.login_container, SignUpFragment())
        }
    }

    private fun signIn(email: String, password: String) {

        if (!validateForm()) return
        showDialog(true)

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {

                    if (it.isSuccessful) {
                        // При удачной авторизации переходим на MainActivity
                        login(auth.currentUser)
                    } else {
                        // Показываем тост об ошибки авторизации
                        toast(context!!, R.string.error_sign_in)
                        login(null)
                    }
                    showDialog(false)
                }


    }

    private fun showDialog(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
            layoutEmail.visibility = View.GONE
            layoutPass.visibility = View.GONE
            signUp.visibility = View.GONE
            singInButton.visibility = View.GONE

        } else {
            progressBar.visibility = View.GONE
            layoutEmail.visibility = View.VISIBLE
            layoutPass.visibility = View.VISIBLE
            signUp.visibility = View.VISIBLE
            singInButton.visibility = View.VISIBLE
        }
    }

    private fun validateForm(): Boolean {
        return when {
            TextUtils.isEmpty(fieldEmail.text.toString()) -> {
                fieldEmail.error = resources.getString(R.string.is_not_empty)
                false
            }

            !android.util.Patterns.EMAIL_ADDRESS.matcher(fieldEmail.text.toString()).matches() -> {
                fieldEmail.error = resources.getString(R.string.is_never_email)
                false
            }

            TextUtils.isEmpty(fieldPassword.text.toString()) -> {
                fieldPassword.error = resources.getString(R.string.is_not_empty)
                false
            }

            else -> {
                fieldEmail.error = null
                fieldPassword.error = null
                true
            }
        }
    }

    private fun login(user: FirebaseUser?) {

        if (user != null) {
            startActivity(Intent(activity, MainActivity::class.java))
            activity.finish()
        }
    }
}