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
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_NAME_GROUP
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_NAME_GROUP
import java.util.*

class DayViewModel : ViewModel() {

    private val interactor = MainInteractor(FirebaseRealtimeRepository().getInstance())
    private val compositeDisposable = CompositeDisposable()

    private val group = Hawk.get(KEY_NAME_GROUP, DEF_NAME_GROUP)

    private val scheduleList: ArrayList<Schedule> = arrayListOf()
    private val scheduleListLiveData = MutableLiveData<ArrayList<Schedule>>()

    var day :String = ""

    init {

        // При инициализации вытаскиваем текущий день недели
        day = when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            Calendar.TUESDAY -> "tue"
            Calendar.WEDNESDAY -> "wed"
            Calendar.THURSDAY -> "thu"
            Calendar.FRIDAY -> "fri"
            else -> "mon"
        }

        interactor.getScheduleDay(day, group)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    scheduleList.addAll(it)
                    scheduleListLiveData.postValue(it)
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