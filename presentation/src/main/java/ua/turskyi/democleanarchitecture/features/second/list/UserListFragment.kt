package ua.turskyi.democleanarchitecture.features.second.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection
import ua.turskyi.democleanarchitecture.databinding.FragmentListBinding
import ua.turskyi.democleanarchitecture.features.second.list.adapter.UserListFragmentAdapter
import javax.inject.Inject

class UserListFragment : DaggerFragment() {

    companion object {
        fun newInstance() = UserListFragment()
    }


    @Inject
    @field:ViewModelInjection
    lateinit var viewModel: UserListFragmentVM

    lateinit var adapter: UserListFragmentAdapter
    private var _binding: FragmentListBinding? = null

    /* This property is only valid between onCreateView and
 onDestroyView. */
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initObservers() {
        viewModel.usersLiveData.observe(viewLifecycleOwner, {
            adapter.setData(it.toMutableList())
        })
    }

    private fun initAdapter() {
        adapter = UserListFragmentAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity?.applicationContext)
    }
}
