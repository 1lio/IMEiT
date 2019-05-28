package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.base.BaseViewModel
import ru.vyaacheslav.suhov.imeit.repository.entity.User

class LoginViewModel : BaseViewModel() {

    // TODO: ПЕРЕДЕЛАТЬ ЭТОТ БАРДАК!!!

    private val userData = MutableLiveData<User>()
    private var userId: String = ""
    private var user = User()

    private val currentFaculty = localRepository.faculty
    private val currentInstitute = localRepository.institute

    private val selectedListId = MutableLiveData<Int>()

    // Лист со всеми группами
    private val listGroupsData = MutableLiveData<Array<String>>()
    private val listGroup: ArrayList<String> = arrayListOf()

    init {
        userId = localRepository.userId
        getUser()
    }

    private fun observeUser(owner: LifecycleOwner, observer: Observer<User>) {
        userData.observe(owner, observer)
    }

    private fun getGroups() {
        // Лист со всеми группами выбранного института
        interactor.getListGroups(currentInstitute, currentFaculty)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    listGroup.addAll(it)
                    listGroupsData.postValue(listGroup.toTypedArray())
                }
                .apply { compositeDisposable.add(this) }

        selectedListId.postValue(localRepository.groupID)     // ID Группы
    }


    private fun getUser(): User {
        interactor.getUser(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    user = it
                    userData.postValue(user)
                }
                .apply { compositeDisposable.add(this) }

        return user
    }

    private fun serUserId(id: String) {
        localRepository.userId = id
        userId = id
    }

}