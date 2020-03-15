package ua.turskyi.democleanarchitecture.common.di.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import ua.turskyi.democleanarchitecture.App
import ua.turskyi.democleanarchitecture.common.di.module.ActivityInjectorsModule
import ua.turskyi.democleanarchitecture.common.di.module.AppModule
import ua.turskyi.democleanarchitecture.common.di.module.FragmentInjectorsModule
import javax.inject.Singleton

// TODO: 11
@Singleton
@Component(
    modules = [
        AppModule::class,
        ActivityInjectorsModule::class,
        AndroidSupportInjectionModule::class,
        FragmentInjectorsModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}