package ua.turskyi.democleanarchitecture.features.second.list

import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides
import ua.turskyi.democleanarchitecture.common.di.InjectionViewModelProvider
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection

// TODO: 9
@Module
class UserListFragmentModule {

    @ViewModelInjection
    @Provides
    fun provideViewModel(
        userListFragment: UserListFragment,
        provider: InjectionViewModelProvider<UserListFragmentVM>
    ): UserListFragmentVM  = provider.get(userListFragment.activity as FragmentActivity)
}