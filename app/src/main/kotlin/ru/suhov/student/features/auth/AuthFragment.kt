package ru.suhov.student.features.auth

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
import kotlinx.android.synthetic.main.fr_auth.*
import ru.suhov.student.R
import ru.suhov.student.features.account.AccountFragment
import ru.suhov.student.features.viewmodel.AuthState
import ru.suhov.student.features.viewmodel.AuthViewModel

class AuthFragment : Fragment() {

    private lateinit var authModel: AuthViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        authModel = ViewModelProvider(activity!!)[AuthViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, bundle: Bundle?): View? {
        super.onCreateView(inflater, group, bundle)
        return inflater.inflate(R.layout.fr_auth, group, false)
    }

    override fun onResume() {
        super.onResume()

        authModel.observeActionName(activity!!, Observer { action.text = it })
        authModel.observeEnableAction(activity!!, Observer {
            action.isEnabled = it
            action.setTextColor(
                if (action.isEnabled) ContextCompat.getColor(activity!!, R.color.colorAccent)
                else ContextCompat.getColor(activity!!, R.color.gray)
            )
        })

        authModel.observeState(activity!!, Observer {
            updateAnimation(it)
            animationSocial()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        connectViewPager()

        action.setOnClickListener {
            childFragmentManager
                .beginTransaction()
                .replace(R.id.container,
                    AccountFragment()
                )
                .commit()
        }
    }

    private fun connectViewPager() {

        authPager.adapter = AuthAdapter(
            childFragmentManager,
            lifecycle
        )

        TabLayoutMediator(authTabLayout, authPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, pos ->
                tab.text = if (pos == 0) resources.getText(R.string.sign_in) else resources.getText(R.string.sign_up)
            }).attach()

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

    private fun updateAnimation(state: AuthState) {

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

            else -> throw Exception("")
        } as AnimatedVectorDrawable

        authBackground.setImageDrawable(anim)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        anim.start()
    }

    private fun animationSocial() {

        val images = listOf(authGoogle, authVk, authFacebook, authTwitter, authGitHub)
        val animation: Animation =
            if (authModel.getState() == AuthState.RESTORE) AnimationUtils.loadAnimation(
                activity,
                R.anim.drop_down
            )
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

    private fun showRestoreMessage() {
        Toast.makeText(context, getString(R.string.msg_restore), Toast.LENGTH_SHORT).show()
    }
}