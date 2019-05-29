package ru.vyaacheslav.suhov.imeit.viewmodel.view

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.base.BaseViewModel
import ru.vyaacheslav.suhov.imeit.repository.entity.User

class SignUpLastStepModel : BaseViewModel() {

    private val institutesData = MutableLiveData<Array<String>>()
    private val facultyData = MutableLiveData<Array<String>>()
    private val groupsData = MutableLiveData<Array<String>>()

    private val institute = MutableLiveData<String?>()
    private val faculty = MutableLiveData<String?>()
    private val group = MutableLiveData<String?>()

    private val listInstitutes: ArrayList<String> = arrayListOf()
    private val listFaculty: ArrayList<String> = arrayListOf()
    private val listGroup: ArrayList<String> = arrayListOf()

    private val userName = MutableLiveData<String>()

    init {
        getInstitutes()
    }

    fun setInstitute(item: Int) {
        institute.value = institutesData.value?.get(item) ?: ""
    }

    fun setFaculty(item: Int) {
        faculty.value = facultyData.value?.get(item) ?: ""
        getFaculty()
    }

    fun setGroup(item: Int) {
        group.value = groupsData.value?.get(item) ?: ""
        getGroup()
    }

    fun setUserName(name:String) {
        userName.postValue(name)
    }

    fun observeUserName(owner: LifecycleOwner,observer: Observer<String>) {
        userName.observe(owner, observer)
    }


    private fun getInstitutes(): Array<String> {

        interactor.getListInstitutes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    listInstitutes.addAll(it)
                    institutesData.postValue(listInstitutes.toTypedArray())
                }
                .apply { compositeDisposable.add(this) }

        return institutesData.value ?: arrayOf("TEST")
    }


    fun observeInstitutes(owner: LifecycleOwner,observer: Observer<Array<String>>) {
        institutesData.observe(owner, observer)
    }

    fun observeFaculty(owner: LifecycleOwner,observer: Observer<Array<String>>) {
        facultyData.observe(owner, observer)
    }

    fun observeGroup(owner: LifecycleOwner,observer: Observer<Array<String>>) {
        groupsData.observe(owner, observer)
    }


    fun getFaculty(): Array<String> {

        interactor.getListFaculty(institute.value!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    listFaculty.clear()
                    listFaculty.addAll(it)
                    facultyData.postValue(listFaculty.toTypedArray())
                }
                .apply { compositeDisposable.add(this) }

        return facultyData.value ?: arrayOf()
    }

    fun getGroup(): Array<String> {

        interactor.getListGroups(institute.value!!, faculty.value!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    listGroup.clear()
                    listGroup.addAll(it)
                    groupsData.postValue(listGroup.toTypedArray())
                }
                .apply { compositeDisposable.add(this) }

        return groupsData.value ?: arrayOf()
    }

    fun createUser() {

        val user= User()

        interactor.setUser(user)
    }

}