package ua.turskyi.data.common.modules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ua.turskyi.data.api.services.UserApiService
import javax.inject.Singleton

//TODO: 18
@Module
class ApiServicesModule {

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }
}