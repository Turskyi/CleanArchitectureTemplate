package ua.turskyi.democleanarchitecture.features.main

import androidx.lifecycle.MutableLiveData
import io.reactivex.functions.Consumer
import ua.turskyi.democleanarchitecture.common.ui.base.BaseViewModel
import ua.turskyi.domain.models.User
import ua.turskyi.domain.usecase.GetUsersUseCase
import javax.inject.Inject

// TODO: 6
class MainActivityViewModel @Inject constructor(
    private val usersUseCase: GetUsersUseCase
) : BaseViewModel() {

    private val usersLiveData = MutableLiveData<List<User>>()

    init {
        getUsers()
    }

    private fun getUsers() {
        val disposable = usersUseCase.execute(
            { users: List<User> ->
                usersLiveData.postValue(users)
            },
            {
                if (it != null) {

                }
            })
        compositeDisposable.add(disposable)
    }
}