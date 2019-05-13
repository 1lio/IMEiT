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
import ru.vyaacheslav.suhov.imeit.util.Constants
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_FIRST_RUN
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_GROUP_ID
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_INSTITUTE
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_NAME_GROUP
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_FIST_RUN
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_GROUP_ID
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_INSTITUTE
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_NAME_GROUP
import java.util.*

class MainViewModel : ViewModel() {

    private val interactor = MainInteractor(FirebaseRealtimeRepository().getInstance())
    private val compositeDisposable = CompositeDisposable()
    // Проверки
    private val isFirstRun = MutableLiveData<Boolean>()
    private val isSelectedGroup = MutableLiveData<Boolean>()
    //Toolbar
    private val titleToolbar = MutableLiveData<String>()
    private val subtitleToolbar = MutableLiveData<String>()
    // Настройки
    private val selectedListId = MutableLiveData<Int>()
    private val day = MutableLiveData<String>()
    // Сохраненные  данные
    private val currentFaculty = Hawk.get(Constants.KEY_NAME_FACULTY, Constants.DEF_FACULTY)
    private val currentInstitute = Hawk.get(KEY_INSTITUTE, DEF_INSTITUTE)
    // Лист со всеми группами
    private val listGroups = MutableLiveData<Array<String>>()

    init {

        isFirstRun.value = Hawk.get(KEY_FIST_RUN, DEF_FIRST_RUN)             // Первый запуск
        isSelectedGroup.value = Hawk.get(KEY_GROUP_ID, DEF_GROUP_ID) != 0    // Проверка выбрана ли группа

        // Текущий день недели
        day.value = when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            Calendar.TUESDAY -> "tue"
            Calendar.WEDNESDAY -> "wed"
            Calendar.THURSDAY -> "thu"
            Calendar.FRIDAY -> "fri"
            else -> "mon"
        }

        // Лист со всеми группами выбранного института
        interactor.getListGroups(currentInstitute,currentFaculty)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { listGroups.postValue(it.toTypedArray()) }
                .apply { compositeDisposable.add(this) }

        selectedListId.postValue(Hawk.get(KEY_GROUP_ID, DEF_GROUP_ID))       // ID Группы

        titleToolbar.value = Hawk.get(KEY_INSTITUTE, DEF_INSTITUTE)           // Институт
        subtitleToolbar.value = Hawk.get(KEY_NAME_GROUP, DEF_NAME_GROUP)      // Группа
    }

    fun getListGroups(): Array<String> = listGroups.value ?: arrayOf("Группа не выбрана")

    fun getSelectedId(): Int = selectedListId.value ?: 0

    fun setSelectedId(id: Int) {

        Hawk.put(KEY_FIST_RUN, false)                        // Если хотябы раз было вызвано, ставим что не первый запуск
        isSelectedGroup.value = id > 0

        Hawk.put(KEY_NAME_GROUP, getListGroups()[id])        // Сохраняем имя выбранной группы
        Hawk.put(KEY_GROUP_ID, id)                           // Сохраняем ID выбранной группы

        selectedListId.value = id                            // Сохраяняем в LiveData выбранный ID
        setSubtitle(getListGroups()[getSelectedId()])        // В качестве подзаголовка ставим имя выбранной группы
    }

    fun isFirstRun(): Boolean = isFirstRun.value ?: false

    fun isSelectedGroup(): Boolean = isSelectedGroup.value ?: false

    fun observeTitle(owner: LifecycleOwner, observer: Observer<String>) {
        titleToolbar.observe(owner, observer)
    }
    fun observeSubtitle(owner: LifecycleOwner, observer: Observer<String>) {
        subtitleToolbar.observe(owner, observer)
    }

    private fun setSubtitle(group: String) {
        subtitleToolbar.postValue(group)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
        compositeDisposable.clear() // Береженого Бог...
    }
}