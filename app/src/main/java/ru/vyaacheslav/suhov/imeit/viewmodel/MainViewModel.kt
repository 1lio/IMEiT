package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.orhanobut.hawk.Hawk
import ru.vyaacheslav.suhov.imeit.repository.AppRepository
import ru.vyaacheslav.suhov.imeit.util.AppConfig.KEY_FIST_RUN
import ru.vyaacheslav.suhov.imeit.util.AppConfig.KEY_GROUP
import ru.vyaacheslav.suhov.imeit.util.AppConfig.KEY_GROUP_ID
import ru.vyaacheslav.suhov.imeit.util.AppConfig.KEY_INSTITUTE
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_FIRST_RUN
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_GROUP
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_GROUP_ID
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_INSTITUTE
import ru.vyaacheslav.suhov.imeit.viewmodel.StateSelectedGroup.*

class MainViewModel : ViewModel() {

    private val state = MutableLiveData<StateSelectedGroup>()
    private val selectedListId = MutableLiveData<Int>()
    private val listGroups = MutableLiveData<Array<String>>()
    private val titleToolbar = MutableLiveData<String>()
    private val subtitleToolbar = MutableLiveData<String>()

    init {
        listGroups.value = AppRepository().getListGroup()
        selectedListId.value = Hawk.get(KEY_GROUP_ID, DEF_GROUP_ID)

        // Инициализируем состояние, необходимо удостовериться что группа выбрана
        state.value = when {
            Hawk.get(KEY_FIST_RUN, DEF_FIRST_RUN) == true -> FIRST_RUN
            Hawk.get(KEY_GROUP, DEF_GROUP) == DEF_GROUP || Hawk.get(KEY_GROUP_ID, DEF_GROUP_ID) == 0 -> EMPTY_GROUP
            Hawk.get(KEY_GROUP_ID, DEF_GROUP_ID) > 0 -> SELECTED_GROUP
            else -> SELECTED_GROUP
        }

        titleToolbar.value = Hawk.get(KEY_INSTITUTE, DEF_INSTITUTE)
        subtitleToolbar.value = Hawk.get(KEY_GROUP, DEF_GROUP)
    }


    fun observeTitle(owner: LifecycleOwner, observer: Observer<String>) {
        titleToolbar.observe(owner, observer)
    }

    fun observeSubtitle(owner: LifecycleOwner, observer: Observer<String>) {
        subtitleToolbar.observe(owner, observer)
    }

    fun setNameInstitute(institute: String) {
        Hawk.put(KEY_INSTITUTE, institute)
        titleToolbar.postValue(institute)
    }

    fun setNameGroup(group: String) {
        Hawk.put(KEY_GROUP, group)
        subtitleToolbar.postValue(group)
    }

    fun observeState(owner: LifecycleOwner, observer: Observer<StateSelectedGroup>) {
        state.observe(owner, observer)
    }

    fun getListGroups(): Array<String> = listGroups.value ?: arrayOf("ERROR")

    fun getSelectedId(): Int = selectedListId.value ?: 0
    fun setSelectedId(id: Int) {
        selectedListId.value = id
        setNameGroup(getListGroups()[getSelectedId()])
        setState(if (getSelectedId() == 0) EMPTY_GROUP else SELECTED_GROUP)

        Hawk.put(KEY_FIST_RUN, false) // Если хотябы раз было вызвано изменение состяния, ставим что не первый запуск
        Hawk.put(KEY_GROUP, getListGroups()[id])
    }

    fun setState(stateSelectedGroup: StateSelectedGroup) {
        state.value = stateSelectedGroup
    }

    fun getState(): StateSelectedGroup = state.value ?: FIRST_RUN
}