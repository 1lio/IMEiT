package ru.assistant.core.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.assistant.core.contract.AppNavigation

abstract class BaseFragment : Fragment {

    constructor()
    constructor(layout: Int) : super(layout)

    var mainActivity: AppNavigation? = null
    abstract val state: Byte

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as AppNavigation
    }

}