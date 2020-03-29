package ua.turskyi.democleanarchitecture

import androidx.multidex.MultiDexApplication
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ua.turskyi.democleanarchitecture.common.di.component.DaggerAppComponent
import javax.inject.Inject

// TODO: 1
//  TODO: 12
class App : MultiDexApplication(), HasAndroidInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = activityInjector

    override fun onCreate() {
        super.onCreate()
        setupDaggerAppComponent()
    }

    private fun setupDaggerAppComponent() {
        DaggerAppComponent.builder().application(this).build().inject(this)
    }
}