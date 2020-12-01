package ru.assistant.ui.activities

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@RunWith(AndroidJUnit4::class)
internal class SplashScreenTest {

    @Test
    fun startMainActivity() {
        Intents.init()

        val activityScenario: ActivityScenario<SplashScreen> =
            ActivityScenario.launch(SplashScreen::class.java)

        activityScenario.moveToState(Lifecycle.State.RESUMED)

        sleep(1000L) // Sleep before start MainActivity
        intended(hasComponent(MainActivity::class.java.name))

        Intents.release()
        activityScenario.moveToState(Lifecycle.State.DESTROYED)
    }
}