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
import ru.vyaacheslav.suhov.imeit.repository.entity.Buildings

class MapsListViewModel : ViewModel() {

    private val listMap: ArrayList<Buildings> = arrayListOf()
    private val listLiveData = MutableLiveData<ArrayList<Buildings>>()
    private val interactor = MainInteractor(FirebaseRealtimeRepository().getInstance())
    private val compositeDisposable = CompositeDisposable()

    init {
        interactor.getListBuildings().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    listMap.addAll(it)
                    listLiveData.postValue(listMap)
                }.apply { compositeDisposable.add(this) }
    }

    fun observeListBuilding(owner: LifecycleOwner, observer: Observer<ArrayList<Buildings>>) {
        listLiveData.observe(owner, observer)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}