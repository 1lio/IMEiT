package ru.suhov.student

import android.app.Application
import com.google.firebase.database.FirebaseDatabase
import com.orhanobut.hawk.Hawk

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Hawk.init(applicationContext).build()

        // Включаем работу RealtimeDatabase в offline
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)

    }

}