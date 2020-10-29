package ru.student.assistant.core.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.student.assistant.core.contract.ActivityContract

abstract class BaseFragment(layout: Int) : Fragment(layout) {

    var mainActivity: ActivityContract? = null
    abstract val state: Byte

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as ActivityContract
    }

}