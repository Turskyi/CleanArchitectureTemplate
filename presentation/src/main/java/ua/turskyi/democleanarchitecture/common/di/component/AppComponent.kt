package ua.turskyi.democleanarchitecture.common.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import ua.turskyi.data.common.modules.DataModule
import ua.turskyi.democleanarchitecture.App
import ua.turskyi.democleanarchitecture.common.di.modules.ActivityInjectorsModule
import ua.turskyi.democleanarchitecture.common.di.modules.AppModule
import ua.turskyi.democleanarchitecture.common.di.modules.FragmentInjectorsModule
import ua.turskyi.democleanarchitecture.common.di.modules.RxSchedulersModule
import javax.inject.Singleton

// TODO: 11
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        RxSchedulersModule::class,
        DataModule::class,
        ActivityInjectorsModule::class,
        FragmentInjectorsModule::class
    ]
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