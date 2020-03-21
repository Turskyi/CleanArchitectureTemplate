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
import ua.turskyi.democleanarchitecture.features.main.detail.DetailFragment
import ua.turskyi.democleanarchitecture.features.second.list.adapter.ExampleAdapter
import ua.turskyi.domain.models.User
import javax.inject.Inject

/**
 * A simple [ListFragment] subclass.
 */
class UserListFragment : Fragment(R.layout.fragment_list) {

    companion object {
        fun newInstance(): ListFragment = ListFragment()
    }

    lateinit var adapter: ExampleAdapter

    @Inject
    @field:ViewModelInjection
    lateinit var viewModel: ListFragmentVM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initObservers()
    }

    private fun initObservers() {
        viewModel.usersLiveData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it.toMutableList())
        })

    }

    private fun initAdapter() {
        adapter = ExampleAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity?.applicationContext)
    }
}
