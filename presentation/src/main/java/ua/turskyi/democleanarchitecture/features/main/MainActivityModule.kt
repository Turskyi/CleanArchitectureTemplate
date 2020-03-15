package ua.turskyi.democleanarchitecture.features.main

import dagger.Module
import dagger.Provides
import ua.turskyi.democleanarchitecture.common.di.InjectionViewModelProvider
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection

// TODO: 9
@Module
class MainActivityModule {

    @ViewModelInjection
    @Provides
    fun provideViewModel(
        activity: MainActivity,
        provider: InjectionViewModelProvider<MainActivityViewModel>
    ): MainActivityViewModel  = provider.get(activity)
}