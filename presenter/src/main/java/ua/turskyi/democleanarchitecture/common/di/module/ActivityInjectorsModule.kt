package ua.turskyi.democleanarchitecture.common.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ua.turskyi.democleanarchitecture.features.main.MainActivity
import ua.turskyi.democleanarchitecture.features.main.MainActivityModule

//TODO: 10
@Module
abstract class ActivityInjectorsModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivityInjector(): MainActivity

}