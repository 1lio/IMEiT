package ru.vyaacheslav.suhov.imeit.viewmodel

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.base.BaseViewModel
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref
import ru.vyaacheslav.suhov.imeit.util.CallGenerator
import ru.vyaacheslav.suhov.imeit.view.adapters.entity.CallItem

class CallSetupViewModel : BaseViewModel() {

    private val currentCallPref = MutableLiveData<CallPref>()
    private val previewListData = MutableLiveData<ArrayList<CallItem>>()

    // Установки с которыми будем работать
    private var pref: CallPref = CallPref() // Инициализируем по умолчанию
    private val prefData = MutableLiveData<CallPref>()

    init {
        // Получилось частичное дублирование с CallTimeViewModel <- Исправить

        // В начале нужно проверить измененно ли расписание звонков
        prefData.postValue(if (localRepository.isCustomScheduleCall) customPref() else defaultPref())

        // Заполняем лист с превью
        previewListData.postValue(generateList(pref))
    }

    fun getPref(): CallPref = currentCallPref.value ?: pref
    fun setPref(preferences: CallPref) = currentCallPref.postValue(preferences)

    fun observePreviewList(owner: LifecycleOwner, observer: Observer<ArrayList<CallItem>>) {
        previewListData.observe(owner, observer)
    }

    fun observePref(owner: LifecycleOwner, observer: Observer<CallPref>) {
        currentCallPref.observe(owner, observer)
    }
    // Функция вернет сгенерированный лист
    private fun generateList(pref: CallPref): ArrayList<CallItem> = CallGenerator(prefData.value
            ?: pref).getCallsList()

    fun saveAndPush() {
        // Ставим что у нас кастомные настройки звонков
        localRepository.isCustomScheduleCall = true

        // Отправляем данные
        interactor.setCustomCallPref(pref)
        Log.d("TEST", pref.toString()) // Данные отправляются, но
    }

    fun setDefaultPreferences() {
        defaultPref() // устанвливаем дефолтные настройки
        previewListData.postValue(generateList(pref)) // Перегенирируем список
        localRepository.isCustomScheduleCall = false  // Флаг на дефолтные
    }

    private fun defaultPref(): CallPref {
        // Тут можно проверить дефолтны ли дефолтные настройки и в след раз не лезть на сервер
        // и использовать просто CallPref()
        var preferences = CallPref()
        interactor.getDefaultCallPref()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    preferences = it
                    prefData.postValue(pref)
                }.apply { compositeDisposable.add(this) }
        return preferences
    }

    private fun customPref(): CallPref {

        var preferences = CallPref()
        // Пользовательские установки
        // Вообще все пользовательское будет храниться только локально, делаю так для ДЗ
        interactor.getCustomCallPref()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    preferences = it
                    prefData.postValue(pref)
                }.apply { compositeDisposable.add(this) }
        return preferences
    }
}