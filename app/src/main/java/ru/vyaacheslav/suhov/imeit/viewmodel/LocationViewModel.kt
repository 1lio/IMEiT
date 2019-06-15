package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.base.BaseViewModel
import ru.vyaacheslav.suhov.imeit.entity.EduLocation

class LocationViewModel : BaseViewModel() {

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