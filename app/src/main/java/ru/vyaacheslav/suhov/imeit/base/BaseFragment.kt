package ru.vyaacheslav.suhov.imeit.base

import android.os.Bundle
import androidx.fragment.app.Fragment

/** Базовый фрагмент */
abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true // Не даем фрагментам умирать
    }
}