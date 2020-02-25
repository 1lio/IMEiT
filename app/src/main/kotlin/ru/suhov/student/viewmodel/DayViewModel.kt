package ru.suhov.student.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.suhov.student.base.BaseViewModel
import ru.suhov.student.entity.Schedule
import ru.suhov.student.gateway.ScheduleInteractorImpl
import ru.suhov.student.util.getDayAcronym

class DayViewModel : BaseViewModel() {

    private val interactor = ScheduleInteractorImpl().getInstance()

    // LiveData
    private val dayLiveData = MutableLiveData<String>()
    private val scheduleListLiveData = MutableLiveData<ArrayList<Schedule>>()
    // Список с расписанием
    private val listSchedule: ArrayList<Schedule> = arrayListOf()

    init {
        // При инициализации вытаскиваем текущий день недели
        dayLiveData.postValue(getDayAcronym())

        // По умолчанию подключаемся к текущему дню
        setSchedule(dayLiveData.value ?: getDayAcronym())
    }

    fun setDay(day: String) = dayLiveData.postValue(day)

    fun setSchedule(day: String) {

        interactor
            .getScheduleDay(day)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                listSchedule.clear()
                listSchedule.addAll(it)
                scheduleListLiveData.postValue(listSchedule)
            }.apply { compositeDisposable.add(this) }
    }

    fun observeSchedule(owner: LifecycleOwner, observer: Observer<ArrayList<Schedule>>) {
        scheduleListLiveData.observe(owner, observer)
    }
}