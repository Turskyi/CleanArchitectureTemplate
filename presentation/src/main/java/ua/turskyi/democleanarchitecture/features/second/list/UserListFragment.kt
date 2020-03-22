package ua.turskyi.democleanarchitecture.features.second.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import ua.turskyi.democleanarchitecture.R
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection
import ua.turskyi.democleanarchitecture.common.ui.base.BaseFragment
import ua.turskyi.democleanarchitecture.features.second.list.adapter.UserListFragmentAdapter
import javax.inject.Inject

/**
 * A simple [ListFragment] subclass.
 */
class UserListFragment : BaseFragment() {

    companion object {
        fun newInstance()= UserListFragment()
    }

    lateinit var adapterUser: UserListFragmentAdapter

    override fun layoutRes() = R.layout.fragment_list

    @Inject
    @field:ViewModelInjection
    lateinit var viewModel: UserListFragmentVM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initObservers()
    }

    private fun initObservers() {
        viewModel.usersLiveData.observe(viewLifecycleOwner, Observer {
            adapterUser.setData(it.toMutableList())
        })

    }

    private fun initAdapter() {
        adapterUser = UserListFragmentAdapter()
        recyclerView.adapter = adapterUser
        recyclerView.layoutManager = LinearLayoutManager(activity?.applicationContext)
    }
}
