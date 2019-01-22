package ru.vyaacheslav.suhov.imeit.viewModel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel

/** View Model FAB */

class ModelFloatingActionButton : ViewModel() {

    private var visibilityFab = MutableLiveData<Boolean>()

    fun observeVisibilityFAB(owner: LifecycleOwner, observer: Observer<Boolean>) {
        visibilityFab.observe(owner, observer)
    }

    fun setVisibilityFab(value: Boolean) {
        visibilityFab.postValue(value)
    }

}