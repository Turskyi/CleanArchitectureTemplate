package ua.turskyi.democleanarchitecture.features.second.list

import androidx.lifecycle.MutableLiveData
import io.reactivex.functions.Consumer
import ua.turskyi.democleanarchitecture.common.ui.base.BaseViewModel
import ua.turskyi.domain.models.User
import ua.turskyi.domain.usecase.GetUsersUseCase
import javax.inject.Inject

class ListFragmentVM @Inject constructor(private val usersUseCase: GetUsersUseCase) :
    BaseViewModel() {

    val usersLiveData = MutableLiveData<List<User>>()

    init {
        getUsers()
    }

    private fun getUsers() {
        val disposable = usersUseCase.execute(
            Consumer {
                usersLiveData.postValue(it)
            },
            Consumer {
if (it != null){

}
            })
        compositeDisposable.add(disposable)
    }
}