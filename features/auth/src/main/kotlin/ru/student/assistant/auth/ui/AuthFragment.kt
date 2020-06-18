package ru.student.assistant.auth.ui

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fr_auth.*
import ru.student.assistant.auth.R
import ru.student.assistant.auth.viewmodel.AuthViewModel
import ru.student.assistant.auth.viewmodel.enums.AuthState

class AuthFragment : Fragment() {

    private lateinit var authModel: AuthViewModel
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, bundle: Bundle?): View? {
        super.onCreateView(inflater, group, bundle)
        authModel = ViewModelProvider(activity!!)[AuthViewModel::class.java]
        return inflater.inflate(R.layout.fr_auth, group, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Подлючаем ViewPager
        connectViewPager()

        // Наблюдаем за назавние Action
        authModel.observeActionName(activity!!, Observer { action.text = it })

        // Поведение кнопки Action
        authModel.observeEnableAction(activity!!, Observer {
            action.isEnabled = it
            action.setTextColor(
                if (it) ContextCompat.getColor(activity!!, R.color.colorAccent)
                else ContextCompat.getColor(activity!!, R.color.gray)
            )
        })

        // Смотрим за состоянием state
        authModel.observeState(activity!!, Observer {
            updateAnimation(it)                 // Обновляем анимацию
            animationSocial(it)                 // Обновляем анимацию соцсетей
            updateActionName(it)                // Обновляем имя
            processAction(it)                   // Обновляем обработчик
            authModel.setEnableAction(false)    // Сбрасываем доступность кнопки
        })
    }

    private fun processAction(state: AuthState) {

        // Обрабатываем нажатия
        action.setOnClickListener {
            when (state) {
                AuthState.SIGN_IN -> signIn()
                AuthState.SIGN_UP -> signUp()
                AuthState.RESTORE -> restore()
                else -> return@setOnClickListener // Прочие не обрабатываются
            }
        }
    }

    private fun connectViewPager() {

        authPager.adapter = AuthPagerAdapter(activity!!.supportFragmentManager, lifecycle)

        // Настраиваем заголовки
        TabLayoutMediator(authTabLayout, authPager,
            TabLayoutMediator.TabConfigurationStrategy { t, p ->
                t.text =
                    if (p == 0) resources.getText(R.string.sign_in)
                    else resources.getText(R.string.sign_up)
            }).attach()

        // Обрабатываем перелистывания
        authPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 0) {
                    authModel.setActionName(resources.getString(R.string.sign_in))
                    authModel.setState(AuthState.SIGN_IN)
                } else {
                    authModel.setActionName(resources.getString(R.string.sign_up))
                    authModel.setState(AuthState.SIGN_UP)
                }
            }
        })
    }

    private fun updateActionName(state: AuthState) {

        // В зависимости от state обновляем название через viewModel
        val name = when (state) {
            AuthState.SIGN_IN -> resources.getString(R.string.sign_in)
            AuthState.SIGN_UP -> resources.getString(R.string.sign_up)
            AuthState.RESTORE -> resources.getString(R.string.restore)
            else -> resources.getString(R.string.sign_in)
        }

        authModel.setActionName(name)
    }

    private fun updateAnimation(state: AuthState) {

        // Делаем красивую анимацию через костыль ViewModel (state , lastState)

        val aToB = ContextCompat.getDrawable(activity!!, R.drawable.ic_u_start)
        val bToA = ContextCompat.getDrawable(activity!!, R.drawable.ic_u_finish)
        val bToC = ContextCompat.getDrawable(activity!!, R.drawable.ic_u_attempt)
        val cToB = ContextCompat.getDrawable(activity!!, R.drawable.ic_u_attempt2)

        val anim = when (state) {
            AuthState.SIGN_IN -> if (authModel.getLastState() == AuthState.SIGN_IN) aToB else cToB

            AuthState.SIGN_UP -> {
                authModel.setLastState(AuthState.SIGN_IN)
                bToA
            }

            AuthState.RESTORE -> {
                authModel.setLastState(AuthState.RESTORE)
                bToC
            }
            else -> return
        } as AnimatedVectorDrawable

        authBackground.setImageDrawable(anim)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        anim.start()
    }

    // Кривая анимация выезда соц сетей
    private fun animationSocial(state: AuthState) {

        val images = listOf(authGoogle, authVk, authGitHub)
        val animation: Animation =
            if (state == AuthState.RESTORE) AnimationUtils.loadAnimation(activity, R.anim.drop_down)
            else AnimationUtils.loadAnimation(activity, R.anim.drop_up)

        images.forEach {

            when (AuthState.RESTORE) {
                authModel.getState() -> {
                    it.startAnimation(animation)
                    it.visibility = View.INVISIBLE
                }
                authModel.getLastState() -> {
                    it.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.drop_up))
                    it.visibility = View.VISIBLE
                }

                else -> it.visibility = View.VISIBLE
            }
        }

    }

    private fun signIn() {
        authModel.signIn()
        Toast.makeText(context, "SignIN", Toast.LENGTH_LONG).show()
    }

    private fun signUp() {
        Toast.makeText(context, "SignUP", Toast.LENGTH_LONG).show()
    }

    private fun restore() {
        // Затычка
        showRestoreMessage()
    }

    private fun showRestoreMessage() {
        Toast.makeText(context, getString(R.string.msg_restore) + " ${authModel.getEmail()}", Toast.LENGTH_LONG).show()
    }

}
