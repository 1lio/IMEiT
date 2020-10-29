package ru.student.assistant.schedule.features.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.student.assistant.core.entity.Schedule
import ru.student.assistant.repo.schedule.ScheduleInteractorImpl
import ru.student.assistant.schedule.platform.BaseViewModel

class DayViewModel : BaseViewModel() {

    private val interactor = ScheduleInteractorImpl().getInstance()
    private val dayLiveData = MutableLiveData<String>()
    private val scheduleListLiveData = MutableLiveData<ArrayList<Schedule>>()
    private val listSchedule: ArrayList<Schedule> = arrayListOf()

    init {
        // При инициализации вытаскиваем текущий день недели
     //   dayLiveData.postValue(getDayAcronym())

        // По умолчанию подключаемся к текущему дню
     //   setSchedule(dayLiveData.value ?: getDayAcronym())
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