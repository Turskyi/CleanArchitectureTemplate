package ua.turskyi.data.common.modules

import dagger.Module
import dagger.Provides
import ua.turskyi.data.repository.UsersRepositoryImpl
import ua.turskyi.domain.repositories.UserRepository
import javax.inject.Singleton

@Module
class RepositoriesModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        usersRepositoryImpl: UsersRepositoryImpl
    ): UserRepository = usersRepositoryImpl
}