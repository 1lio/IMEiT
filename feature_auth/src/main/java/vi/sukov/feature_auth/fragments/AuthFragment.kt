package vi.sukov.feature_auth.fragments

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fr_auth.*
import vi.sukov.feature_auth.R

class AuthFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fr_auth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AuthAdapter()

        auth_pager.adapter = adapter

        TabLayoutMediator(auth_tab_layout, auth_pager,
                TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                    when (position) {
                        0 -> {
                            tab.text = resources.getText(R.string.sign_in)
                        }
                        1 -> {
                            tab.text = resources.getText(R.string.sign_up)
                        }
                    }
                }).attach()

        var animVector = ContextCompat.getDrawable(activity!!.applicationContext, R.drawable.ic_u_start) as AnimatedVectorDrawable
        anim_vector.setImageDrawable(animVector)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        animVector = ContextCompat.getDrawable(activity!!.applicationContext, R.drawable.ic_u_start) as AnimatedVectorDrawable
        anim_vector.setImageDrawable(animVector)
        animVector.start()
    }
}