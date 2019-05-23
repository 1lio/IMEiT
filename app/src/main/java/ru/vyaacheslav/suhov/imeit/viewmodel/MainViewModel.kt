package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.base.BaseViewModel
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_NAME_GROUP

class MainViewModel : BaseViewModel() {

    // Проверки
    private val isFirstRun = MutableLiveData<Boolean>()
    private val isSelectedGroup = MutableLiveData<Boolean>()
    //Toolbar
    private val titleToolbar = MutableLiveData<String>()
    private val subtitleToolbar = MutableLiveData<String>()
    // Настройки
    private val selectedListId = MutableLiveData<Int>()
    // Сохраненные  данные | Институт и факультет почти не используются. В дальнейшем будут.
    private val currentFaculty = localRepository.faculty
    private val currentInstitute = localRepository.institute
    private val currentGroup = localRepository.group
    // Лист со всеми группами
    private val listGroupsData = MutableLiveData<Array<String>>()
    private val listGroup: ArrayList<String> = arrayListOf()

    init {
        isFirstRun.value = localRepository.isFirstRun              // Проверка на первый запуск
        isSelectedGroup.value = localRepository.isSelectedGroup    // Проверка выбрана ли группа

        // Лист со всеми группами выбранного института
        interactor.getListGroups(currentInstitute, currentFaculty)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    listGroup.addAll(it)
                    listGroupsData.postValue(listGroup.toTypedArray())
                }
                .apply { compositeDisposable.add(this) }

        selectedListId.postValue(localRepository.groupID)     // ID Группы

        titleToolbar.value = currentInstitute                 // Институт
        subtitleToolbar.value = currentGroup                  // Группа
    }

    fun getListGroups(): Array<String> = listGroupsData.value ?: arrayOf(DEF_NAME_GROUP)

    fun getSelectedId(): Int = selectedListId.value ?: 0

    fun setSelectedId(id: Int) {

        // Если хотябы раз было вызвано, ставим что не первый запуск
        localRepository.isFirstRun = false
        isSelectedGroup.value = id > 0

        // Сохраняем имя выбранной группы и ID
        localRepository.group = getListGroups()[id]
        localRepository.groupID = id

        // Сохраяняем в LiveData выбранный ID
        selectedListId.value = id

        // В качестве подзаголовка ставим имя выбранной группы
        setSubtitle(getListGroups()[getSelectedId()])
    }

    fun isFirstRun(): Boolean = isFirstRun.value ?: false

    fun isSelectedGroup(): Boolean = isSelectedGroup.value ?: false

    fun observeTitle(owner: LifecycleOwner, observer: Observer<String>) {
        titleToolbar.observe(owner, observer)
    }

    fun observeSubtitle(owner: LifecycleOwner, observer: Observer<String>) {
        subtitleToolbar.observe(owner, observer)
    }

    private fun setSubtitle(group: String) { subtitleToolbar.postValue(group) }
}