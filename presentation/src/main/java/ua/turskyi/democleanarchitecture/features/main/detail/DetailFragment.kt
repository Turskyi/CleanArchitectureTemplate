package ua.turskyi.democleanarchitecture.features.main.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ua.turskyi.democleanarchitecture.R
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection
import ua.turskyi.democleanarchitecture.common.ui.base.BaseFragment
import ua.turskyi.democleanarchitecture.features.main.MainActivityViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment(private var id: Long) : BaseFragment() {

    companion object {
        fun newInstance(id: Long): DetailFragment = DetailFragment(id)
    }

    @Inject
    @field:ViewModelInjection
    lateinit var viewModel: DetailFragmentViewModel

    override fun layoutRes() = R.layout.fragment_detail

    override fun onStart() {
        super.onStart()
        view?.run {
            val id = id
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putLong("id", id)
    }

    fun setId(id: Long) {
        this.id = id
    }
}
