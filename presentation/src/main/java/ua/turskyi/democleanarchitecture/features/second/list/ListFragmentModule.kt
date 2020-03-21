package ua.turskyi.democleanarchitecture.features.second.list

import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides
import ua.turskyi.democleanarchitecture.common.di.InjectionViewModelProvider
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection

// TODO: 9
@Module
class ListFragmentModule {

    @ViewModelInjection
    @Provides
    fun provideViewModel(
        fragmentUser: UserListFragment,
        provider: InjectionViewModelProvider<ListFragmentVM>
    ): ListFragmentVM  = provider.get(fragmentUser.activity as FragmentActivity)
}