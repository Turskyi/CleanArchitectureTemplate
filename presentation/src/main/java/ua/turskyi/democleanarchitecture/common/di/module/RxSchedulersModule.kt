package ua.turskyi.democleanarchitecture.common.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ua.turskyi.domain.common.di.quilefires.schedulers.ComputationScheduler
import ua.turskyi.domain.common.di.quilefires.schedulers.IoScheduler
import ua.turskyi.domain.common.di.quilefires.schedulers.MainScheduler

//TODO 16
@Module
class RxSchedulersModule {
    @Provides
    @MainScheduler
   internal fun mainThread() = AndroidSchedulers.mainThread()

    @Provides
    @IoScheduler
    internal fun ioThread() = Schedulers.io()

    @Provides
    @ComputationScheduler
    internal fun computationThread() = Schedulers.computation()
}