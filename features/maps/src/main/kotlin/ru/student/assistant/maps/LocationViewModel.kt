package ru.student.assistant.maps

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.student.assistant.core.entity.EduLocation
import ru.suhov.student.core.platform.BaseViewModel
import ru.suhov.student.features.gateway.BuildingsInteractorImpl

class LocationViewModel : BaseViewModel() {

    private val interactor = BuildingsInteractorImpl().getInstance()
    private val listLiveData = MutableLiveData<ArrayList<EduLocation>>()
    private val listMap: ArrayList<EduLocation> = arrayListOf()

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

    fun observeListBuilding(owner: LifecycleOwner, observer: Observer<ArrayList<EduLocation>>) {
        listLiveData.observe(owner, observer)
    }
}