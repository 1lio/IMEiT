package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.base.BaseViewModel
import ru.vyaacheslav.suhov.imeit.repository.entity.User

class UserModel : BaseViewModel() {

    private val userID = localRepository.userId
    private val userData = MutableLiveData<User>()

    fun getUser(): User {

        var user: User
        interactor.getUser(userID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    user = it
                    userData.postValue(user)
                }
                .apply { compositeDisposable.add(this) }

        return userData.value ?: User()
    }

}