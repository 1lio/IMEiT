package ru.suhov.student

import android.app.Application
import com.google.firebase.database.FirebaseDatabase
import com.orhanobut.hawk.Hawk
import ru.suhov.student.core.di.AppComponent
import ru.suhov.student.core.di.AppModule
import ru.suhov.student.core.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        Hawk.init(applicationContext).build()

        // Включаем работу RealtimeDatabase в offline
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)

        appComponent.inject(this)
    }

}