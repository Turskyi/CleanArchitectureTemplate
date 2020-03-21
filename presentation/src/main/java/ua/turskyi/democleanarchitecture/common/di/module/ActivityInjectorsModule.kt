package ua.turskyi.democleanarchitecture.common.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ua.turskyi.democleanarchitecture.features.second.SecondActivity
import ua.turskyi.democleanarchitecture.features.second.SecondActivityModule
import ua.turskyi.democleanarchitecture.features.main.MainActivity
import ua.turskyi.democleanarchitecture.features.main.MainActivityModule

//TODO: 10
@Module
abstract class ActivityInjectorsModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivityInjector(): MainActivity

    @ContributesAndroidInjector(modules = [SecondActivityModule::class])
    abstract fun homeActivityInjector(): SecondActivity
}