package ru.vyaacheslav.suhov.imeit.app

import android.app.Application
import com.orhanobut.hawk.Hawk

// Основной класс приложения
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Инициализация библиотеки Hawk.
        // Библитека нужна для хранения не особо важных данных
        Hawk.init(applicationContext).build()
    }
}