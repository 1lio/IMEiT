package ru.student.assistant.auth.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fr_auth.*
import ru.student.assistant.auth.R

class AuthFragment : Fragment(R.layout.fr_auth) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectViewPager()
    }

    private fun connectViewPager() {

        val signInStr = resources.getText(R.string.sign_in)
        val signUpStr = resources.getText(R.string.sign_up)

        authPager.adapter = AuthPagerAdapter(parentFragmentManager, lifecycle)

        // Настраиваем заголовки
        TabLayoutMediator(authTabLayout, authPager) { t, p ->
            t.text = if (p == 0) signInStr else signUpStr
        }.attach()

        // Обрабатываем перелистывания
        authPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position == 0) {
                    action.text = resources.getString(R.string.sign_in)
                    //     authModel.setActionName(resources.getString(R.string.sign_in))
                    //   authModel.setState(AppConstants.FRAGMENT_SIGN_IN)
                } else {
                    action.text = resources.getString(R.string.sign_up)
                    // authModel.setActionName(resources.getString(R.string.sign_up))
                    // authModel.setState(AppConstants.FRAGMENT_SIGN_UP)
                }

            }
        })
    }
}