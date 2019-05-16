package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.repository.FirebaseRealtimeRepository
import ru.vyaacheslav.suhov.imeit.repository.MainInteractor
import ru.vyaacheslav.suhov.imeit.repository.entity.MapData

class MapsListViewModel : ViewModel() {

    private val listMap: ArrayList<MapData> = arrayListOf()
    private val listLiveData = MutableLiveData<ArrayList<MapData>>()
    private val interactor = MainInteractor(FirebaseRealtimeRepository().getInstance())
    private val compositeDisposable = CompositeDisposable()

    init {
        interactor.getListBuildings().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    listMap.clear()
                    listMap.addAll(it)
                    listLiveData.postValue(listMap)
                }.apply { compositeDisposable.add(this) }
    }

    fun observeListBuilding(owner: LifecycleOwner, observer: Observer<ArrayList<MapData>>) {
        listLiveData.observe(owner, observer)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}