package ru.vyaacheslav.suhov.imeit.viewmodel.view

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.base.BaseViewModel
import ru.vyaacheslav.suhov.imeit.entity.User
import ru.vyaacheslav.suhov.imeit.util.Constants.NOT_SELECT

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
    private val signUpButton = MutableLiveData<Boolean>()

    init {
        signUpButton.value = false
        getInstitutes()
    }

    fun setInstitute(item: Int) {
        institute.value = institutesData.value?.get(item) ?: NOT_SELECT
    }

    fun setFaculty(item: Int) {
        faculty.value = facultyData.value?.get(item) ?: NOT_SELECT
    }

    fun setGroup(item: Int) {
        group.value = groupsData.value?.get(item) ?: NOT_SELECT
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

        return institutesData.value ?: arrayOf(NOT_SELECT)
    }

    fun setSignUpButton(value: Boolean) {
        signUpButton.value = value
    }

    fun observeSignUpButton(owner: LifecycleOwner, observer: Observer<Boolean>) {
        signUpButton.observe(owner, observer)
    }


    fun observeInstitutes(owner: LifecycleOwner, observer: Observer<Array<String>>) {
        institutesData.observe(owner, observer)
    }

    fun observeFaculty(owner: LifecycleOwner, observer: Observer<Array<String>>) {
        facultyData.observe(owner, observer)
    }

    fun observeGroup(owner: LifecycleOwner, observer: Observer<Array<String>>) {
        groupsData.observe(owner, observer)
    }

    fun getFacultyList(): Array<String> {

        interactor.getListFaculty(getInstitute())
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

    fun getGroupList(): Array<String> {

        interactor.getListGroups(getInstitute(), getFaculty())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    listGroup.clear()
                    listGroup.addAll(it)
                    groupsData.postValue(listGroup.toTypedArray())
                }.apply { compositeDisposable.add(this) }

        return groupsData.value ?: arrayOf()
    }

    fun setUserName(name: String) { userName.value = name }
    fun getUser(): User = User(null, getName(), getInstitute(), getFaculty(), getGroup())

    private fun getInstitute(): String = institute.value ?: NOT_SELECT
    private fun getFaculty(): String = faculty.value ?: NOT_SELECT
    private fun getGroup(): String = group.value ?: NOT_SELECT
    private fun getName(): String = userName.value ?: NOT_SELECT
}
