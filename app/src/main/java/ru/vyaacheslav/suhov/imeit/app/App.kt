package ru.vyaacheslav.suhov.imeit.app

import android.app.Application
import com.orhanobut.hawk.Hawk
import ru.vyaacheslav.suhov.imeit.app.di.AppComponent
import ru.vyaacheslav.suhov.imeit.app.di.DaggerAppComponent

// Основной класс приложения
class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()

        // Инициализация библиотеки Hawk.
        Hawk.init(applicationContext).build()
    }
}