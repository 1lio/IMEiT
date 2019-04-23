package ru.vyaacheslav.suhov.imeit.app

import android.app.Application
import android.content.Context
import com.orhanobut.hawk.Hawk

// Основной класс приложения
class App : Application() {

    lateinit var appContext:Context

    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext

        // Инициализация библиотеки Hawk.
        // Библитека нужна для хранения не особо важных данных
        Hawk.init(appContext).build()
    }
}