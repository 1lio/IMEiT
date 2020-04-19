package ru.suhov.student.features.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.suhov.student.features.AppConstants.FRAGMENT_EMPTY_SCHEDULE
import ru.suhov.student.features.AppConstants.FRAGMENT_SCHEDULE
import ru.suhov.student.features.AppConstants.FRAGMENT_AUTH
import ru.suhov.student.features.repository.LocalRepository

/** Вью модель поведения в активити*/
class ControlViewModel : ViewModel() {

    private val localRepository = LocalRepository().getInstance()
    private val currentFragmentID = MutableLiveData<Byte?>()
    private val currentDialogID = MutableLiveData<Byte?>()
    private val visibilityUI = MutableLiveData<Boolean>()

    init {
        currentFragmentID.value = getFragmentSchedule()
        visibilityUI.value = true
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
            else -> FRAGMENT_AUTH
        }
    }
}