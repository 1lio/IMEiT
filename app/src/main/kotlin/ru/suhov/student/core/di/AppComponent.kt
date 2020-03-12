package ru.suhov.student.core.di

import dagger.Component
import ru.suhov.student.App
import ru.suhov.student.core.di.viewmodel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(application: App)
    //   fun inject(routeActivity: RouteActivity)

//    fun inject(moviesFragment: MoviesFragment)
//    fun inject(movieDetailsFragment: MovieDetailsFragment)
}