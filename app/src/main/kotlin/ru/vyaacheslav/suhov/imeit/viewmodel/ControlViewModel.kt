package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.vyaacheslav.suhov.imeit.repository.LocalRepository
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_EMPTY_SCHEDULE
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_SCHEDULE
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_SIGN_IN

/** Вью модель поведения в активити*/
class ControlViewModel : ViewModel() {

    private val localRepository = LocalRepository().getInstance()
    private val currentFragmentID = MutableLiveData<Byte?>()
    private val currentDialogID = MutableLiveData<Byte?>()
    private val visibilityUI = MutableLiveData<Boolean>()

    init {
        currentFragmentID.value = getFragmentSchedule()
        visibilityUI.value = localRepository.isAuth
        currentDialogID.value = null
    }

    fun setFragmentId(id: Byte) {
        currentFragmentID.value = id
    }

    fun setDialogID(id: Byte) {
        currentDialogID.value = id
    }

    fun observeVisibleUI(owner: LifecycleOwner, observer: Observer<Boolean>) {
        visibilityUI.observe(owner, observer)

    }

    fun setVisibleUI(visibility: Boolean) {
        visibilityUI.value = visibility
    }

    fun observeFragmentID(owner: LifecycleOwner, observer: Observer<Byte?>) {
        currentFragmentID.observe(owner, observer)
    }

    fun observeDialogID(owner: LifecycleOwner, observer: Observer<Byte?>) {
        currentDialogID.observe(owner, observer)
    }

    fun getFragmentSchedule(): Byte {
        return when {
            localRepository.isAuth && localRepository.isSelectedGroup -> FRAGMENT_SCHEDULE
            localRepository.isAuth && !localRepository.isSelectedGroup -> FRAGMENT_EMPTY_SCHEDULE
            else -> FRAGMENT_SIGN_IN
        }
    }
}