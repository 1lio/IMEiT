package ru.vyaacheslav.suhov.imeit.app.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app:Application) {

    @Provides
    @Singleton
    fun providesApplication():Application = app
}