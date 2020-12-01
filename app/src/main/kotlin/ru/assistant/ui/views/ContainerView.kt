package ru.assistant.ui.views

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
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
import ru.assistant.core.AppConstants.CONTAINER_ID
import ru.student.assistant.R

/** == ContainerView ==

FrameLayout
- FrameLayout(fragmentContainer)
- CoordinatorLayout
- BottomAppBar
- FloatingActionButton
 */

class ContainerView(context: Context) : FrameLayout(context) {

    private val fragmentContainer: FrameLayout = FrameLayout(context)
    private val coordinatorLayout: CoordinatorLayout = CoordinatorLayout(context)
    private val appBar: BottomAppBar = BottomAppBar(context)
    private val fab: FloatingActionButton = FloatingActionButton(context)

    init {

        // Первоночальная настройка
        // По умолчанию виден только контейнер | fab и appBar INVISIBLE
        configureRoot()
        configureCoordinator()
        configureContainer()
        configureAppBar()
        configureFab()

        // строим дерево view
        merge()
    }

    // Разметка

    private fun configureRoot() {
        id = CONTAINER_ID
        layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
    }

    private fun configureContainer() {
        fragmentContainer.apply {
            id = CONTAINER_FRAGMENT_ID
            layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT).apply {
                bottomMargin = resources.getDimensionPixelSize(R.dimen.bottom_bar_margin)
            }
        }
    }

    private fun configureCoordinator() {
        coordinatorLayout.apply {
            id = COORDINATOR_ID
            layoutParams = CoordinatorLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT).apply {
                gravity = Gravity.END or Gravity.BOTTOM
            }
        }
    }

    private fun configureAppBar() {
        val appBarHeight = resources.getDimensionPixelSize(R.dimen.toolbar_size)

        val appBarParams = CoordinatorLayout.LayoutParams(MATCH_PARENT, appBarHeight).apply {
            gravity = Gravity.BOTTOM
        }

        val whiteColorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
            ContextCompat.getColor(context, R.color.white), BlendModeCompat.SRC_ATOP
        )

        appBar.apply {
            id = APP_BAR_ID
            visibility = INVISIBLE
            fabAlignmentMode = FAB_ALIGNMENT_MODE_END
            layoutParams = appBarParams
            overflowIcon!!.colorFilter = whiteColorFilter
            backgroundTint = ContextCompat.getColorStateList(context, R.color.colorPrimary)
            menu.addMenu()
        }
    }

    private fun configureFab() {
        val fabSize = resources.getDimensionPixelSize(R.dimen.fab_size)
        val bottom = resources.getDimensionPixelSize(R.dimen.fab_margin)
        val right = resources.getDimensionPixelSize(R.dimen.fab_margin_right)

        val fabParams = CoordinatorLayout.LayoutParams(MATCH_PARENT, fabSize).apply {
            anchorId = APP_BAR_ID
            setMargins(0, 0, right, bottom)
            gravity = Gravity.BOTTOM or Gravity.END
        }

        val bgTint = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.colorAccent))

        fab.apply {
            id = FAB_ID
            setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_account))
            setColorFilter(Color.WHITE)
            backgroundTintList = bgTint
            layoutParams = fabParams
            hide()
        }

    }

    private fun merge() {
        addView(fragmentContainer)
        addView(coordinatorLayout.apply {
            addView(appBar)
            addView(fab)
        })
    }

    // Управление

    var isVisibleFab: Boolean = false
        set(value) {
            field = value
            fab.visibility = false.toVisibility()
            fab.visibility = value.toVisibility()
            updateUI()
        }

    var isVisibleAppBar: Boolean = false
        set(value) {
            field = value
            appBar.visibility = false.toVisibility()
            appBar.visibility = value.toVisibility()
            updateUI()
        }

    fun setFabAction(action: OnClickListener) {
        fab.setOnClickListener(action)
    }

    private fun updateUI() {
        if (isVisibleFab) fab.show() else fab.hide()
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

    private fun Boolean.toVisibility(): Int = if (this) View.VISIBLE else View.GONE

    private companion object {
        const val CONTAINER_FRAGMENT_ID = 101
        const val APP_BAR_ID = 1
        const val COORDINATOR_ID = 2
        const val FAB_ID = 3
    }
}
