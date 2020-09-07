package ru.suhov.student

import android.content.Context
import android.widget.FrameLayout
import com.google.android.material.bottomappbar.BottomAppBar
import ru.student.core.AppConstants.CONTAINER_ID

class ContainerView(context: Context) : FrameLayout(context) {

    private val fragmentContainer: FrameLayout = FrameLayout(context)
    private val appBar: BottomAppBar = BottomAppBar(context)

    init {

        configureContainer()

        configureFragmentContainer()

        configureAppBar()

        merge()
    }

    private fun configureContainer() {
        id = CONTAINER_ID
    }

    private fun configureFragmentContainer() {
        with(fragmentContainer) {
            id = CONTAINER_FRAGMENT_ID
        }

    }

    private fun configureAppBar() {
        with(appBar) {
            id = APP_BAR_ID
        }
    }


    private fun merge() {
        addView(fragmentContainer)
        addView(appBar)
    }

    private companion object {
        const val CONTAINER_FRAGMENT_ID = 100
        const val APP_BAR_ID = 101
    }
}