package ua.turskyi.democleanarchitecture.common.di.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import ua.turskyi.data.common.modules.DataModule
import ua.turskyi.democleanarchitecture.App
import ua.turskyi.democleanarchitecture.common.di.module.ActivityInjectorsModule
import ua.turskyi.democleanarchitecture.common.di.module.AppModule
import ua.turskyi.democleanarchitecture.common.di.module.FragmentInjectorsModule
import ua.turskyi.democleanarchitecture.common.di.module.RxSchedulersModule
import javax.inject.Singleton

// TODO: 11
@Singleton
@Component(
    modules = [
        AppModule::class,
        ActivityInjectorsModule::class,
        AndroidSupportInjectionModule::class,
        FragmentInjectorsModule::class,
        RxSchedulersModule::class,
        DataModule::class]
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