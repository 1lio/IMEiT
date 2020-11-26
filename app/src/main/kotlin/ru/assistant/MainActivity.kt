package ru.assistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.assistant.core.AppConstants.CONTAINER_ID
import ru.assistant.navigation.FragmentNavigation
import ru.assistant.core.AppConstants.FRAGMENT_AUTH
import ru.assistant.core.contract.AppNavigation
import ru.assistant.ui.ContainerView

// Навигация в приложении происходит через AppNavigation который реализует активити. Сратаюсь не
// тащить посторонние либы в проект, чтобы не разрастаться
class MainActivity : AppCompatActivity(), AppNavigation {

    private val fragmentNavigation = FragmentNavigation(this@MainActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ContainerView(this@MainActivity).apply { id = CONTAINER_ID })

        if (savedInstanceState == null) pushFragmentById(FRAGMENT_AUTH, now = true)
    }

    override fun pushFragmentById(id: Byte, container: Int, now: Boolean) {
        fragmentNavigation.pushFragmentById(id, container, now)
    }

    override fun removeFragmentById(id: Byte) {
        fragmentNavigation.removeFragmentById(id)
    }

    override fun showLoader(isShow: Boolean) {
        fragmentNavigation.showLoader(isShow)
    }

}
