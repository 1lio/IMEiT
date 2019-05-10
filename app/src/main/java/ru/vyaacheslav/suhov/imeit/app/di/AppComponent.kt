package ru.vyaacheslav.suhov.imeit.app.di

import dagger.Component
import ru.vyaacheslav.suhov.imeit.app.module.AppModule
import javax.inject.Singleton

@Singleton
@Component( modules = [AppModule::class])
interface AppComponent {


}