package ru.vyaacheslav.suhov.imeit.gateway

import android.view.View
import android.widget.FrameLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.MainActivity
import ru.vyaacheslav.suhov.imeit.view.view.BottomToolbar
import ru.vyaacheslav.suhov.imeit.view.view.UpToolbar


@RunWith(RobolectricTestRunner::class)
class ActivityTest {

    private var activity: MainActivity? = null
    private var fab:FloatingActionButton? = null
    private var container: FrameLayout? = null
    private var isAuthUser:Boolean? = null

    private var toolbar: UpToolbar? = null
    private var bottomBar: BottomToolbar? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        isAuthUser = true

        activity = Robolectric.buildActivity(MainActivity::class.java)
                .create()
                .resume()
                .get()

        fab = activity!!.findViewById(R.id.fab)
        container = activity!!.findViewById(R.id.container)
        toolbar = activity!!.findViewById(R.id.toolbar)
        bottomBar = activity!!.findViewById(R.id.bottom_bar)
    }

    @Test
    @Throws(Exception::class)
    fun activityShouldNotBeNull() {
        // activity = null
        Assert.assertFalse("Activity null", activity == null)
    }


    @Test
    @Throws(Exception::class)
    fun activityCorrectVisibility() {

        fun View.isVisibility():Boolean {
            return !(this.visibility == View.GONE || this.visibility == View.INVISIBLE)
        }

        // При авторизованном пользователе
        // FAB отображаться только на окне настроек времени звонков

        Assert.assertFalse("Пользователь авторизован: fab на переднем плане",isAuthUser != true && fab!!.visibility == View.GONE)
        Assert.assertFalse("Не инициализирован контейнер| null",container == null)
        Assert.assertFalse("Не отображаться Toolbar-ы", toolbar!!.isVisibility() && bottomBar!!.isVisibility())
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        activity = null
    }

}