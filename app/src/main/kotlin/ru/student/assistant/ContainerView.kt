package ru.student.assistant

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.google.android.material.bottomappbar.BottomAppBar
import ru.student.core.AppConstants.CONTAINER_ID

class ContainerView : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    private val fragmentContainer: FrameLayout = FrameLayout(context)
    private val appBar: BottomAppBar = BottomAppBar(context)

    var isVisibleAppBar: Boolean = false

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