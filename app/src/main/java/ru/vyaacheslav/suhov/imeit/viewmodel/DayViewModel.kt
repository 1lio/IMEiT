package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.orhanobut.hawk.Hawk
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.repository.FirebaseRealtimeRepository
import ru.vyaacheslav.suhov.imeit.repository.MainInteractor
import ru.vyaacheslav.suhov.imeit.repository.entity.Schedule
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_FACULTY
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_INSTITUTE
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_NAME_GROUP
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_INSTITUTE
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_NAME_FACULTY
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_NAME_GROUP
import java.util.*
import kotlin.collections.ArrayList

class DayViewModel : ViewModel() {

    private val currentGroup = Hawk.get(KEY_NAME_GROUP, DEF_NAME_GROUP)
    private val currentInstitute = Hawk.get(KEY_INSTITUTE, DEF_INSTITUTE)
    private val currentFaculty = Hawk.get(KEY_NAME_FACULTY, DEF_FACULTY)
    private val listSchedule: ArrayList<Schedule> = arrayListOf()
    private val interactor = MainInteractor(FirebaseRealtimeRepository().getInstance())
    private val dayLiveData = MutableLiveData<String>()
    private val scheduleListLiveData = MutableLiveData<ArrayList<Schedule>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        // При инициализации вытаскиваем текущий день недели
        dayLiveData.postValue(when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            Calendar.TUESDAY -> "tue"
            Calendar.WEDNESDAY -> "wed"
            Calendar.THURSDAY -> "thu"
            Calendar.FRIDAY -> "fri"
            else -> "mon"
        })

        interactor.getScheduleDay(currentInstitute, currentFaculty, getDay(), currentGroup)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    listSchedule.addAll(it)
                    scheduleListLiveData.postValue(listSchedule)
                }.apply { compositeDisposable.add(this) }

    }

    private fun getDay() = dayLiveData.value ?: "mon"
    fun setDay(day: String) = dayLiveData.postValue(day)

    fun setSchedule(day: String) {
        interactor.getScheduleDay(currentInstitute, currentFaculty, day, currentGroup)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    //Ошибка из-за добовления
                    listSchedule.clear()
                    listSchedule.addAll(it)
                    scheduleListLiveData.postValue(listSchedule)
                }.apply { compositeDisposable.add(this) }

    }

    fun observeSchedule(owner: LifecycleOwner, observer: Observer<ArrayList<Schedule>>) {
        scheduleListLiveData.observe(owner, observer)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}