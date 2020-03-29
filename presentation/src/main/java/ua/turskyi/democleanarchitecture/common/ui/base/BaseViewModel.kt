package ua.turskyi.democleanarchitecture.common.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

// TODO: 4
abstract class BaseViewModel: ViewModel() {

    val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}