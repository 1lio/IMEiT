package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.base.BaseViewModel
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref
import ru.vyaacheslav.suhov.imeit.util.CallGenerator
import ru.vyaacheslav.suhov.imeit.util.Constants.CUSTOM
import ru.vyaacheslav.suhov.imeit.util.Constants.DEFAULT
import ru.vyaacheslav.suhov.imeit.view.adapters.entity.CallItem

class CallSetupViewModel : BaseViewModel() {

    private val previewListData = MutableLiveData<ArrayList<CallItem>>() // Лист с превью
    private var previewList = ArrayList<CallItem>()
    // Установки с которыми будем работать
    private var pref: CallPref = CallPref() // Установки
    private val prefData = MutableLiveData<CallPref>()

    init {
        // В начале нужно проверить измененно ли расписание звонков и загрузить нужные данные
        if (localRepository.isCustomScheduleCall) getPref(CUSTOM) else getPref(DEFAULT)

        // Заполняем лист с превью
        previewListData.postValue(generateList(pref))
    }

    fun getPrefData(): CallPref = prefData.value ?: pref

    fun setPref(preferences: CallPref) = prefData.postValue(preferences)

    fun observePreviewList(owner: LifecycleOwner, observer: Observer<ArrayList<CallItem>>) {
        previewListData.observe(owner, observer)
    }

    // Функция вернет сгенерированный лист
    private fun generateList(pref: CallPref): ArrayList<CallItem> =
            CallGenerator(prefData.value ?: pref).getCallsList()

    fun saveAndPush(preferences: CallPref) {
        // Ставим что у нас кастомные настройки звонков
        localRepository.isCustomScheduleCall = true
        // Сохраняем колличество пар
        localRepository.countPair = pref.count
        // Отправляем данные
        interactor.setCustomCallPref(preferences)
    }

    fun setDefaultPreferences() {
        getPref(DEFAULT) // устанвливаем дефолтные настройки
        previewListData.postValue(generateList(pref)) // Перегенирируем список
        localRepository.isCustomScheduleCall = false  // Флаг на дефолтные
        localRepository.countPair = pref.count // Сохраняем колличество пар
    }

    private fun getPref(type: String) {
        if (type == DEFAULT) interactor.getDefaultCallPref() else interactor.getCustomCallPref()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    pref = it

                    previewList.clear()
                    previewList = CallGenerator(pref).getCallsList()

                    prefData.postValue(pref)
                    previewListData.postValue(CallGenerator(it).getCallsList())
                }.apply { compositeDisposable.add(this) }
    }
}