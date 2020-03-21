package ua.turskyi.domain.usecase

import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import ua.turskyi.domain.common.di.quilefires.schedulers.IoScheduler
import ua.turskyi.domain.common.di.quilefires.schedulers.MainScheduler
import ua.turskyi.domain.models.User
import ua.turskyi.domain.repositories.UserRepository
import javax.inject.Inject

// TODO: 16
class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository,
    @IoScheduler private val subscribeOnScheduler: Scheduler,
    @MainScheduler private val observeOnScheduler: Scheduler
) {
    fun execute(
        successConsumer: Consumer<List<User>>,
        errorConsumer: Consumer<String>
    ): Disposable {
        return userRepository.getUsers()
            .subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
            .subscribe({
                successConsumer.accept(it)
            }, {
                errorConsumer.accept(it.message)
            })
    }
}