package ua.turskyi.democleanarchitecture.common.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ua.turskyi.democleanarchitecture.features.main.detail.DetailFragment
import ua.turskyi.democleanarchitecture.features.main.detail.DetailFragmentModule
import ua.turskyi.democleanarchitecture.features.second.list.UserListFragment
import ua.turskyi.democleanarchitecture.features.second.list.UserListFragmentModule

//TODO: 10
@Module
abstract class FragmentInjectorsModule {

    @ContributesAndroidInjector(modules = [DetailFragmentModule::class])
    abstract fun fragmentDetailInjector(): DetailFragment

    @ContributesAndroidInjector(modules = [UserListFragmentModule::class])
    abstract fun fragmentUserListInjector(): UserListFragment

}