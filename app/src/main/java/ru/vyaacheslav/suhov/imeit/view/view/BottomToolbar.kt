package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.MainActivity
import ru.vyaacheslav.suhov.imeit.viewmodel.MainViewModel
import ru.vyaacheslav.suhov.imeit.viewmodel.StateSelectedGroup

class BottomToolbar : BottomAppBar {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    val activity = context as MainActivity
    private val activityModel = ViewModelProviders.of(activity)[MainViewModel::class.java]

    init {
        this.replaceMenu(R.menu.menu)
        this.fabAlignmentMode = FAB_ALIGNMENT_MODE_END
        this.backgroundTint = ContextCompat.getColorStateList(context, R.color.colorPrimary)

        activityModel.observeState(activity, Observer {
            val fab: FloatingActionButton = activity.findViewById(R.id.fab)

            if (it == StateSelectedGroup.EMPTY_GROUP) {
                fab.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_down))
            } else fab.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_schedule))

        })
    }
}