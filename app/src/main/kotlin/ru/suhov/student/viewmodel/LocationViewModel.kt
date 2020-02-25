package ru.suhov.student.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.suhov.student.base.BaseViewModel
import ru.suhov.student.entity.EduBuilding
import ru.suhov.student.gateway.BuildingsInteractorImpl

class LocationViewModel : BaseViewModel() {

    private val interactor = BuildingsInteractorImpl().getInstance()
    private val listLiveData = MutableLiveData<ArrayList<EduBuilding>>()
    private val listMap: ArrayList<EduBuilding> = arrayListOf()

    init {
        interactor
            .getListBuildings().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                listMap.clear()
                listMap.addAll(it)
                listLiveData.postValue(listMap)
            }.apply { compositeDisposable.add(this) }
    }

    fun observeListBuilding(owner: LifecycleOwner, observer: Observer<ArrayList<EduBuilding>>) {
        listLiveData.observe(owner, observer)
    }
}