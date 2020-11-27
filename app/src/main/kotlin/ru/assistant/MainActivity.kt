package ru.assistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.assistant.core.AppConstants.CONTAINER_ID
import ru.assistant.core.AppConstants.FRAGMENT_AUTH
import ru.assistant.navigation.AppNavigation
import ru.assistant.ui.ContainerView

// Навигация в приложении происходит через AppNavigation который реализует активити. Стараюсь не
// тащить посторонние либы в проект
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ContainerView(this@MainActivity).apply { id = CONTAINER_ID })

        if (savedInstanceState == null) AppNavigation(this).pushFragmentById(FRAGMENT_AUTH, now = true)
    }


}
