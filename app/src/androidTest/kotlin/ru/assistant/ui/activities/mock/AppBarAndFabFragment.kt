package ru.assistant.ui.activities.mock

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import ru.assistant.core.base.BaseFragment
import ru.assistant.ui.activities.mock.MockConstants.APPBAR_AND_FAB_FRAGMENT

class AppBarAndFabFragment : BaseFragment() {

    override val state: Byte = APPBAR_AND_FAB_FRAGMENT

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View {
        super.onCreateView(inflater, group, state)
        return TextView(requireContext()).apply {
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            ).apply {
                gravity = Gravity.CENTER
            }
            textAlignment = LinearLayout.TEXT_ALIGNMENT_CENTER
            setTextColor(Color.BLACK)
            text = "APPBAR_AND_FAB"
        }
    }

}