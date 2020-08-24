package ru.student.assistant.auth.ui

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fr_auth.*
import ru.student.assistant.auth.R
import ru.student.assistant.auth.viewmodel.AuthViewModel
import ru.student.assistant.auth.viewmodel.enums.AuthState
import ru.student.core.AppConstants.FRAGMENT_ACCOUNT
import ru.student.core.base.ActivityContract

class AuthFragment : Fragment(R.layout.fr_auth) {

    private lateinit var authModel: AuthViewModel
    private lateinit var contract: ActivityContract

    // В отдельное view
    private lateinit var aToB: AnimatedVectorDrawable
    private lateinit var bToA: AnimatedVectorDrawable
    private lateinit var bToC: AnimatedVectorDrawable
    private lateinit var cToB: AnimatedVectorDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authModel = ViewModelProvider(activity!!)[AuthViewModel::class.java]
        contract = activity as ActivityContract

        // Мы должны чекнуть был ли авторизован, затем либо продолжить, либо перебросить
        if (authModel.isAuth()) contract.pushFragmentById(FRAGMENT_ACCOUNT)
    }

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, group, state)

        aToB = ContextCompat.getDrawable(requireContext(), R.drawable.a) as AnimatedVectorDrawable
        bToA = ContextCompat.getDrawable(requireContext(), R.drawable.b) as AnimatedVectorDrawable
        bToC = ContextCompat.getDrawable(requireContext(), R.drawable.c) as AnimatedVectorDrawable
        cToB = ContextCompat.getDrawable(requireContext(), R.drawable.d) as AnimatedVectorDrawable

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        return inflater.inflate(R.layout.fr_auth, group, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        connectViewPager()  // Подлючаем ViewPager

        // Наблюдаем за назавние Action
        authModel.observeActionName(activity!!, { action.text = it })

        // Поведение кнопки Action
        authModel.observeActionEnabled(activity!!, {
            action.isEnabled = it
            action.setTextColor(
                if (it) ContextCompat.getColor(activity!!, R.color.colorAccent)
                else ContextCompat.getColor(activity!!, R.color.gray)
            )
        })

        // Смотрим за состоянием state
        authModel.observeState(activity!!, {
            updateAnimation(it)                 // Обновляем анимацию
            // animationSocial(it)                 // Обновляем анимацию соцсетей
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
            //authModel.setTap(true)
        }
    }

    private fun connectViewPager() {

        authPager.adapter = AuthPagerAdapter(activity!!.supportFragmentManager, lifecycle)

        // Настраиваем заголовки
        TabLayoutMediator(authTabLayout, authPager) { t, p ->
            t.text =
                if (p == 0) resources.getText(R.string.sign_in) else resources.getText(R.string.sign_up)
        }.attach()

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
        }

        authBackground.setImageDrawable(anim)
        anim.start()
    }

    private fun signIn() {

        //  authModel.signIn()
        val contract: ActivityContract = activity as ActivityContract
        contract.pushFragmentById(FRAGMENT_ACCOUNT)

        //Toast.makeText(context, "SignIN", Toast.LENGTH_LONG).show()
    }

    private fun signUp() {
        Toast.makeText(context, "SignUP", Toast.LENGTH_LONG).show()
    }

    private fun restore() {
        // Затычка
        showRestoreMessage()
    }

    private fun showRestoreMessage() {
        Toast.makeText(
            context,
            getString(R.string.msg_restore) + " ${authModel.getEmail()}",
            Toast.LENGTH_LONG
        ).show()
    }


    private fun setActionName(state: Byte) {
        val text: String = when (state) {
            0.toByte() -> resources.getString(R.string.sign_in)
            1.toByte() -> resources.getString(R.string.sign_up)
            else -> resources.getString(R.string.restore)
        }
        action.text = text
    }
}
