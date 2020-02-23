package ru.vyaacheslav.suhov.imeit.app

import android.app.Application
import android.content.Context
import com.google.firebase.database.FirebaseDatabase
import com.orhanobut.hawk.Hawk

/**
 * Основной класс приложения
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Hawk.init(applicationContext).build()
        // Включаем работу RealtimeDatabase в offline
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }
}