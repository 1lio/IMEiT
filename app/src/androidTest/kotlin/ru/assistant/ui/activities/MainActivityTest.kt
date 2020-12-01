package ru.assistant.ui.activities

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.assistant.ui.activities.mock.MockConstants

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun isShowLoader() {
        val text = "LOADER_TEXT"
        activityScenarioRule.scenario.onActivity {
            it.showLoader(true, text)
        }
    }

    @Test
    fun pushFragmentById() {
        activityScenarioRule.scenario.onActivity {
            it.pushFragmentById(MockConstants.EMPTY_FRAGMENT)
        }
    }

    @Test
    fun removeFragmentById() {

    }


}