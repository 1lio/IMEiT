package ru.vyaacheslav.suhov.imeit.view.ftagments.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.base.BaseFragment

// Пустой фрагмент информирующий что групаа не выбрана
class FragmentEmptyGroup : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_empty, container, false)
    }
}