package ua.turskyi.democleanarchitecture.common.di

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

// TODO: 7
class InjectionViewModelProvider<VM : ViewModel> @Inject constructor(private val lazyViewModel: dagger.Lazy<VM>) {
    @Suppress("UNCHECKED_CAST")
    val viewModelFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>) = lazyViewModel.get() as T
    }

    inline fun <ACTIVITY : FragmentActivity, reified VM : ViewModel> get(activity: ACTIVITY): VM {
        return ViewModelProvider(activity, viewModelFactory).get(VM::class.java)
    }
}