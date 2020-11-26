package ru.assistant.ui

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem.SHOW_AS_ACTION_IF_ROOM
import android.view.MenuItem.SHOW_AS_ACTION_NEVER
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomappbar.BottomAppBar.FAB_ALIGNMENT_MODE_END
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.student.assistant.R

/* == ContainerView ==

    FrameLayout
    - FrameLayout(fragmentContainer)
    - CoordinatorLayout
        - BottomAppBar
        - FloatingActionButton
 */

class ContainerView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null) :
    FrameLayout(context, attr) {

    private val fragmentContainer: FrameLayout = FrameLayout(context)
    private val coordinatorLayout: CoordinatorLayout = CoordinatorLayout(context)
    private val appBar: BottomAppBar = BottomAppBar(context)
    private val fab: FloatingActionButton = FloatingActionButton(context)

    private var isVisibleFab: Boolean = true
    private var isVisibleAppBar: Boolean = true

    init {
        configureFragmentContainer()
        configureAppBar()
        configureFab()
        merge()
    }

    // ParentContainer
    private fun configureFragmentContainer() {

        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT).apply {
            bottomMargin = resources.getDimensionPixelSize(R.dimen.bottom_bar_margin)
        }

        fragmentContainer.apply {
            id = CONTAINER_FRAGMENT_ID
            layoutParams = params
        }
    }


    // AppBar
    private fun configureAppBar() {

        coordinatorLayout.layoutParams = CoordinatorLayout.LayoutParams(
            CoordinatorLayout.LayoutParams.MATCH_PARENT,
            CoordinatorLayout.LayoutParams.MATCH_PARENT
        ).apply {
            id = COORDINATOR_ID
        }

        val appBarHeight = resources.getDimensionPixelSize(R.dimen.toolbar_size)

        val appBarParams = CoordinatorLayout.LayoutParams(MATCH_PARENT, appBarHeight).apply {
            gravity = Gravity.BOTTOM
        }

        appBar.apply {
            id = APP_BAR_ID
            fabAlignmentMode = FAB_ALIGNMENT_MODE_END
            layoutParams = appBarParams
            overflowIcon!!.colorFilter =
                BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                    ContextCompat.getColor(context, R.color.white), BlendModeCompat.SRC_ATOP
                )
            backgroundTint = ContextCompat.getColorStateList(context, R.color.colorPrimary)
            // navigationIcon = ContextCompat.getDrawable(context, R.drawable.ic_baseline_menu_24)
            menu.addMenu()
        }
    }

    private fun configureFab() {

        val fabParams =
            CoordinatorLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
                .apply {
                    anchorId = if (isVisibleFab) APP_BAR_ID else NO_ID
                }

        fab.apply {
            visibility = if (isVisibleAppBar) View.VISIBLE else View.GONE
            id = FAB_ID
            setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_account))
            setColorFilter(Color.WHITE)
            backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.colorAccent))
            layoutParams = fabParams
        }
    }

    private fun merge() {
        addView(fragmentContainer)
        addView(coordinatorLayout.apply {
            addView(appBar)
            addView(fab)
        })
    }

    private fun Menu.addMenu() {

        this.add(resources.getString(R.string.nav_schedule))
            .setIcon(R.drawable.ic_schedule)
            .setShowAsAction(SHOW_AS_ACTION_IF_ROOM)

        this.add(resources.getString(R.string.nav_chat))
            .setIcon(R.drawable.ic_chat)
            .setShowAsAction(SHOW_AS_ACTION_IF_ROOM)

        this.add(resources.getString(R.string.nav_account))
            .setIcon(R.drawable.ic_account)
            .setShowAsAction(SHOW_AS_ACTION_IF_ROOM)

        this.add(resources.getString(R.string.nav_maps))
            .setIcon(R.drawable.ic_location)
            .setShowAsAction(SHOW_AS_ACTION_IF_ROOM)

        this.add(resources.getString(R.string.nav_calls))
            .setIcon(R.drawable.ic_calls)
            .setShowAsAction(SHOW_AS_ACTION_IF_ROOM)

        this.add(resources.getString(R.string.nav_find_teacher))
            .setShowAsAction(SHOW_AS_ACTION_NEVER)

        this.add(resources.getString(R.string.nav_day_x))
            .setShowAsAction(SHOW_AS_ACTION_NEVER)

    }

    // Public
    fun setFabAction(action: OnClickListener) {
        fab.setOnClickListener(action)
    }

    fun setVisibleFab(isVisible: Boolean) {
        isVisibleFab = isVisible
    }

    fun setVisibleAppBar(isVisible: Boolean) {
        isVisibleAppBar = isVisible
    }

    // APPBAR
    fun ContainerView.showAppBar() {
    }

    fun ContainerView.hideAppBar() {

    }

    // FAB
    fun ContainerView.showFab() {
        fab.show()
    }

    fun ContainerView.hideFab() {
        fab.hide()
    }

    private companion object {
        const val CONTAINER_FRAGMENT_ID = 101
        const val APP_BAR_ID = 1
        const val COORDINATOR_ID = 2
        const val FAB_ID = 3
    }
}
