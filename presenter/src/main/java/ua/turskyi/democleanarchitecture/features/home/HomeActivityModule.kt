package ua.turskyi.democleanarchitecture.features.home

import dagger.Module
import dagger.Provides
import ua.turskyi.democleanarchitecture.common.di.InjectionViewModelProvider
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection

// TODO: 9
@Module
class HomeActivityModule {

    @ViewModelInjection
    @Provides
    fun provideViewModel(
        activity: HomeActivity,
        provider: InjectionViewModelProvider<HomeActivityVM>
    ): HomeActivityVM  = provider.get(activity)
}