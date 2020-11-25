package ru.assistant.auth.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ru.student.assistant.auth.R

class AuthFragment : Fragment(R.layout.fr_auth) {

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View {
        super.onCreateView(inflater, group, state)
        val v: View = inflater.inflate(R.layout.fr_auth, group, false)

    /*
        val authPager: ViewPager2 = v.findViewById(R.id.authPager)
        val action: TextView = v.findViewById(R.id.action)
        val authTabLayout: TabLayout = v.findViewById(R.id.authTabLayout)

        authPager.adapter = AuthPagerAdapter(parentFragmentManager, lifecycle)

        val signInStr = resources.getText(R.string.sign_in)
        val signUpStr = resources.getText(R.string.sign_up)

        // Настраиваем заголовки
        TabLayoutMediator(authTabLayout, authPager) { t, p ->
            t.text = if (p == 0) signInStr else signUpStr
        }.attach()

        // Обрабатываем перелистывания
        authPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    action.text = resources.getString(R.string.sign_in)
                    //   authModel.setActionName(resources.getString(R.string.sign_in))
                    //   authModel.setState(AppConstants.FRAGMENT_SIGN_IN)
                } else {
                    action.text = resources.getString(R.string.sign_up)
                    // authModel.setActionName(resources.getString(R.string.sign_up))
                    // authModel.setState(AppConstants.FRAGMENT_SIGN_UP)
                }
            }
        })
*/
        return v
    }

    companion object {
        fun newInstance() = AuthFragment()
    }

}
