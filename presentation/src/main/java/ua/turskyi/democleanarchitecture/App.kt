package ua.turskyi.democleanarchitecture

import android.app.Activity
import androidx.multidex.MultiDexApplication
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ua.turskyi.democleanarchitecture.common.di.components.DaggerAppComponent
import javax.inject.Inject

// TODO: 1
//  TODO: 12
class App: MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()
        setupDaggerAppComponent()
    }

   private fun setupDaggerAppComponent(){
        DaggerAppComponent.builder().application(this).build().inject(this)
    }
}