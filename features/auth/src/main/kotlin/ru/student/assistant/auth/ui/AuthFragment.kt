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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fr_auth.*
import ru.student.assistant.auth.R
import ru.student.assistant.auth.viewmodel.AuthState
import ru.student.assistant.auth.viewmodel.AuthViewModel

class AuthFragment : Fragment() {

    private lateinit var authViewModel: AuthViewModel

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, group, state)
        return inflater.inflate(R.layout.fr_auth, group, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        authViewModel = ViewModelProvider(activity!!)[AuthViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()

        authViewModel.observeEnableAction(activity!!, Observer {
            action.isEnabled = it
            action.text =
                resources.getStringArray(R.array.auth_actions)[authViewModel.getState()!!.toInt()]
            action.setTextColor(
                if (action.isEnabled) ContextCompat.getColor(activity!!, R.color.colorAccent)
                else ContextCompat.getColor(activity!!, R.color.gray)
            )
        })

        authViewModel.observeState(activity!!, Observer {
            updateAnimation(it)
            // animationSocial()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectViewPager()
        val fm = activity!!.supportFragmentManager

        action.setOnClickListener {
            /*  fm
                  .beginTransaction()
                  .replace(
                      R.id.container,
                      AccountFragment()
                  )
                  .commit()*/
        }
    }

    private fun connectViewPager() {

        authPager.adapter = AuthPagerAdapter(activity!!.supportFragmentManager, lifecycle)

        TabLayoutMediator(authTabLayout, authPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, pos ->
                tab.text = if (pos == 0) resources.getText(R.string.sign_in) else resources.getText(R.string.sign_up)
            }).attach()

        authPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position == 0) {
                    authViewModel.setState(AuthState.SIGN_IN)
                } else {
                    authViewModel.setState(AuthState.SIGN_UP)
                }
            }
        })
    }

    private fun updateAnimation(state: Byte) {

        val aToB = ContextCompat.getDrawable(activity!!, R.drawable.ic_u_start)
        val bToA = ContextCompat.getDrawable(activity!!, R.drawable.ic_u_finish)
        val bToC = ContextCompat.getDrawable(activity!!, R.drawable.ic_u_attempt)
        val cToB = ContextCompat.getDrawable(activity!!, R.drawable.ic_u_attempt2)

        val anim = when (state) {

            AuthState.SIGN_IN -> if (authViewModel.getLastState() == AuthState.SIGN_IN) aToB else bToA

            AuthState.SIGN_UP -> bToA

            AuthState.RESTORE -> bToC

            else -> throw Exception("")
        } as AnimatedVectorDrawable

        authBackground.setImageDrawable(anim)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        anim.start()
    }

    /*  private fun animationSocial() {

          val images = listOf(authGoogle, authVk, authFacebook, authTwitter, authGitHub)
          val animation: Animation =
              if (authViewModel.getState() == AuthState.RESTORE) AnimationUtils.loadAnimation(
                  activity,
                  R.anim.drop_down
              )
              else AnimationUtils.loadAnimation(activity, R.anim.drop_up)

          images.forEach {

              when (AuthState.RESTORE) {
                  authViewModel.getState() -> {
                      it.startAnimation(animation)
                      it.visibility = View.INVISIBLE
                  }
                  authViewModel.getLastState() -> {
                      it.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.drop_up))
                      it.visibility = View.VISIBLE
                  }

                  else -> it.visibility = View.VISIBLE
              }
          }

      }*/

    private fun showRestoreMessage() {
        Toast.makeText(context, getString(R.string.msg_restore), Toast.LENGTH_SHORT).show()
    }

}