package ua.turskyi.democleanarchitecture.common.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ua.turskyi.democleanarchitecture.App
import javax.inject.Singleton

//TODO: 2
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApplication(app: App): Application = app

    @Singleton
    @Provides
    fun provideApplicationContext(app: App): Context = app.applicationContext
}