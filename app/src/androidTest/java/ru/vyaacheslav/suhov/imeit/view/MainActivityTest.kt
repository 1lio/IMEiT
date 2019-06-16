package ru.vyaacheslav.suhov.imeit.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.vyaacheslav.suhov.imeit.R

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    private var isSigned:Boolean? = false

    @Before
    private fun setUp() {
        isSigned = true
    }

    @Test
    private fun signInUiTest() {

        onView(withId(R.id.sign_in))
                .perform(click())
                .check(matches(isDisplayed()))
    }
}