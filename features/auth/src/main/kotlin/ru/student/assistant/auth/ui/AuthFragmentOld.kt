package ru.student.assistant.auth.ui

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fr_auth.*
import ru.student.assistant.auth.R
import ru.student.assistant.auth.viewmodel.AuthViewModel
import ru.student.core.AppConstants.FRAGMENT_AUTH
import ru.student.core.AppConstants.FRAGMENT_RESTORE
import ru.student.core.AppConstants.FRAGMENT_SIGN_IN
import ru.student.core.AppConstants.FRAGMENT_SIGN_UP
import ru.student.core.base.BaseFragment
import ru.student.core.ext.showToast

class AuthFragmentOld : BaseFragment(R.layout.fr_auth) {

    override val state: Byte = FRAGMENT_AUTH

    private lateinit var authModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authModel = ViewModelProvider(requireActivity())[AuthViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val colorAccent = ContextCompat.getColor(requireContext(), R.color.colorAccent)
        val colorGray = ContextCompat.getColor(requireContext(), R.color.gray)

        val activity = requireActivity()

        // Подлючаем ViewPager
        connectViewPager()

        // Наблюдаем за назавние Action
        authModel.observeActionName(activity, {
            action.text = it
        })

        // Поведение кнопки Action
        authModel.observeActionEnabled(activity, {
            action.isEnabled = it
            action.setTextColor(if (it) colorAccent else colorGray)
        })

        // Смотрим за состоянием state
        authModel.observeState(activity, {
            updateActionName(it)                // Обновляем имя
            processAction(it)                   // Обновляем обработчик
            authModel.setEnableAction(false)    // Сбрасываем доступность кнопки
        })

    }

    private fun processAction(state: Byte) {

        // Обрабатываем нажатия
        action.setOnClickListener {
            when (state) {
                FRAGMENT_SIGN_IN -> signIn()
                FRAGMENT_SIGN_UP -> signUp()
                FRAGMENT_RESTORE -> restore()
                else -> return@setOnClickListener // Прочие не обрабатываются
            }
        }
    }

    private fun connectViewPager() {

        val signInStr = resources.getText(R.string.sign_in)
        val signUpStr = resources.getText(R.string.sign_up)

        authPager.adapter = AuthPagerAdapter(requireFragmentManager(), lifecycle)

        // Настраиваем заголовки
        TabLayoutMediator(authTabLayout, authPager) { t, p ->
            t.text = if (p == 0) signInStr else signUpStr
        }.attach()

        // Обрабатываем перелистывания
        authPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position == 0) {
                    authModel.setActionName(resources.getString(R.string.sign_in))
                    authModel.setState(FRAGMENT_SIGN_IN)
                } else {
                    authModel.setActionName(resources.getString(R.string.sign_up))
                    authModel.setState(FRAGMENT_SIGN_UP)
                }

            }
        })
    }

    private fun updateActionName(state: Byte) {

        // В зависимости от state обновляем название через viewModel
        val name = when (state) {
            FRAGMENT_SIGN_IN -> resources.getString(R.string.sign_in)
            FRAGMENT_SIGN_UP -> resources.getString(R.string.sign_up)
            FRAGMENT_RESTORE -> resources.getString(R.string.restore)
            else -> return
        }

        authModel.setActionName(name)
    }

    private fun signIn() {
        //  mainActivity!!.pushFragmentById(FRAGMENT_ACCOUNT)
    }

    private fun signUp() {
        showToast("SignUP")
    }

    private fun restore() {
        authModel.restore()
        showToast(getString(R.string.msg_restore) + " ${authModel.getEmail()}")

        mainActivity!!.removeFragmentById(FRAGMENT_RESTORE)
        authAppBarLayout.visibility = View.VISIBLE
        authModel.setState(FRAGMENT_SIGN_IN)
    }
}