package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.base.BaseViewModel
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref
import ru.vyaacheslav.suhov.imeit.util.CallGenerator
import ru.vyaacheslav.suhov.imeit.util.Constants.CUSTOM
import ru.vyaacheslav.suhov.imeit.util.Constants.DEFAULT
import ru.vyaacheslav.suhov.imeit.view.adapters.entity.CallItem

class CallSetupViewModel : BaseViewModel() {

    // Установки с которыми будем работать
    private var pref: CallPref = CallPref() // Установки
    private val prefData = MutableLiveData<CallPref>()
    private var list: ArrayList<CallItem> = arrayListOf()
    private val listData = MutableLiveData<ArrayList<CallItem>>()

    init {
        // В начале нужно проверить измененно ли расписание звонков и загрузить нужные данные
        if (localRepository.isCustomScheduleCall) getPref(CUSTOM) else getPref(DEFAULT)
    }

    fun getPrefData(): CallPref = prefData.value ?: pref

    fun setPref(preferences: CallPref) {
        pref = preferences
    }

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
        localRepository.isCustomScheduleCall = false  // Флаг на дефолтные
        localRepository.countPair = pref.count        // Сохраняем колличество пар
    }

     private fun getPref(type: String) {
        if (type == DEFAULT) interactor.getCallPref(DEFAULT) else interactor.getCallPref(CUSTOM)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    pref = it

                    list.clear()
                    list = CallGenerator(it).getCallsList()

                    prefData.postValue(pref)
                    listData.postValue(CallGenerator(it).getCallsList())
                }.apply { compositeDisposable.add(this) }
    }
}