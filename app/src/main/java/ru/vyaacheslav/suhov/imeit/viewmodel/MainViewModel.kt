package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.orhanobut.hawk.Hawk
import ru.vyaacheslav.suhov.imeit.repository.AppRepository
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_FIRST_RUN
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_GROUP_ID
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_INSTITUTE
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_NAME_GROUP
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_FIST_RUN
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_GROUP_ID
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_INSTITUTE
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_NAME_GROUP

class MainViewModel : ViewModel() {

    private val isFirstRun = MutableLiveData<Boolean>()
    private val isSelectedGroup = MutableLiveData<Boolean>()

    private val listGroups = MutableLiveData<Array<String>>()
    private val selectedListId = MutableLiveData<Int>()

    private val titleToolbar = MutableLiveData<String>()
    private val subtitleToolbar = MutableLiveData<String>()

    init {
        isFirstRun.value = Hawk.get(KEY_FIST_RUN, DEF_FIRST_RUN)             // Первый запуск
        listGroups.value = AppRepository().getListGroup()                    // Список всех групп
        isSelectedGroup.value = Hawk.get(KEY_GROUP_ID, DEF_GROUP_ID) != 0    // Проверка выбрана ли группа
        selectedListId.postValue(Hawk.get(KEY_GROUP_ID, DEF_GROUP_ID))       // ID Группы

        titleToolbar.value = Hawk.get(KEY_INSTITUTE, DEF_INSTITUTE)           // Институт
        subtitleToolbar.value = Hawk.get(KEY_NAME_GROUP, DEF_NAME_GROUP)      // Группа
    }

    fun isSelectedGroup(): Boolean = isSelectedGroup.value ?: false

    fun getListGroups(): Array<String> = listGroups.value ?: arrayOf("ERROR")

    fun getSelectedId(): Int = selectedListId.value ?: 0

    fun setSelectedId(id: Int) {

        val name: String = getListGroups()[id]

        Hawk.put(KEY_FIST_RUN, false)                        // Если хотябы раз было вызвано, ставим что не первый запуск
        isSelectedGroup.value = id > 0

        Hawk.put(KEY_NAME_GROUP, name)                       // Сохраняем имя выбранной группы
        Hawk.put(KEY_GROUP_ID, id)                           // Сохраняем ID выбранной группы

        selectedListId.value = id                            // Сохраяняем в LiveData выбранный ID
        setNameGroup(getListGroups()[getSelectedId()])       // В качестве подзаголовка ставим имя выбранной группы
    }

    private fun setNameGroup(group: String) { subtitleToolbar.postValue(group) }

    fun isFirstRun(): Boolean = isFirstRun.value ?: false

    fun observeTitle(owner: LifecycleOwner, observer: Observer<String>) { titleToolbar.observe(owner, observer) }

    fun observeSubtitle(owner: LifecycleOwner, observer: Observer<String>) { subtitleToolbar.observe(owner, observer)}
}