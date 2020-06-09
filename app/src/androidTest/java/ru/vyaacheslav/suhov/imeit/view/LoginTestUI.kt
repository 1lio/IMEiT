package ru.vyaacheslav.suhov.imeit.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.vyaacheslav.suhov.imeit.R

@RunWith(AndroidJUnit4::class)
class LoginTestUI {

    companion object {
        const val EMAIL_SIGN_IN = "test@test.ru"
        const val EMAIL_SIGN_UP = "test2@test.ru"
        const val PASSWORD = "123456"
    }

    @Rule @JvmField var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun signIn() {

        onView(ViewMatchers.withId(R.id.ed_email)).perform(ViewActions.typeText(EMAIL_SIGN_IN))

        onView(ViewMatchers.withId(R.id.ed_pass)).perform(ViewActions.typeText(PASSWORD))

        onView(ViewMatchers.withId(R.id.btn_sign_in)).perform(ViewActions.click()).check(ViewAssertions.matches(ViewMatchers.isEnabled()))

        onView(ViewMatchers.withId(R.id.recycler)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun signUp() {
        // Перейти в форму регистрации
        onView(ViewMatchers.withId(R.id.btn_sign_up)).perform(ViewActions.click())
        // Заполнить данные для регистрации
        onView(ViewMatchers.withId(R.id.ed_email_u)).perform(ViewActions.typeText(EMAIL_SIGN_UP))
        onView(ViewMatchers.withId(R.id.ed_pass_u)).perform(ViewActions.typeText(PASSWORD))
        onView(ViewMatchers.withId(R.id.ed_pass_u_re)).perform(ViewActions.typeText(PASSWORD))
        // Перейти на следующий шаг регистрации
        onView(ViewMatchers.withId(R.id.btn_next_u)).perform(ViewActions.click())
        // Найти recycler
        onView(ViewMatchers.withId(R.id.recycler)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}