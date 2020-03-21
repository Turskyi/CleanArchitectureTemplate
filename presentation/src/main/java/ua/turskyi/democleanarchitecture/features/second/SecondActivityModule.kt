package ua.turskyi.democleanarchitecture.features.second

import dagger.Module
import dagger.Provides
import ua.turskyi.democleanarchitecture.common.di.InjectionViewModelProvider
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection

// TODO: 9
@Module
class SecondActivityModule {

    @ViewModelInjection
    @Provides
    fun provideViewModel(
        activity: SecondActivity,
        provider: InjectionViewModelProvider<SecondActivityVM>
    ): SecondActivityVM  = provider.get(activity)
}