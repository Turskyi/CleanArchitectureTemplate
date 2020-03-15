package ua.turskyi.democleanarchitecture.features.main.detail

import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides
import ua.turskyi.democleanarchitecture.common.di.InjectionViewModelProvider
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection

// TODO: 9
@Module
class DetailFragmentModule {

    @ViewModelInjection
    @Provides
    fun provideViewModel(
        fragment: DetailFragment,
        provider: InjectionViewModelProvider<DetailFragmentViewModel>
    ): DetailFragmentViewModel  = provider.get(fragment.activity as FragmentActivity)
}