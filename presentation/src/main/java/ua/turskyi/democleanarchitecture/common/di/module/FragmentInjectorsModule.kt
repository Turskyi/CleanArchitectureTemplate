package ua.turskyi.democleanarchitecture.common.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ua.turskyi.democleanarchitecture.features.main.detail.DetailFragment
import ua.turskyi.democleanarchitecture.features.main.detail.DetailFragmentModule

//TODO: 10
@Module
abstract class FragmentInjectorsModule {

    @ContributesAndroidInjector(modules = [DetailFragmentModule::class])
    abstract fun fragmentDetailInjector(): DetailFragment

}