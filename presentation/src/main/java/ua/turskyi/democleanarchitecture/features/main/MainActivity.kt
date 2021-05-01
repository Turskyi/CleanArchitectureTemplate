package ua.turskyi.democleanarchitecture.features.main

import android.app.Activity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.FragmentTransaction
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast
import ua.turskyi.democleanarchitecture.R
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection
import ua.turskyi.democleanarchitecture.databinding.ActivityMainBinding
import ua.turskyi.democleanarchitecture.features.main.detail.DetailFragment
import ua.turskyi.democleanarchitecture.features.second.SecondActivity
import javax.inject.Inject

// TODO: 5
class MainActivity : DaggerAppCompatActivity() {

    companion object {
        const val VISIBILITY = "visibility"
        fun getIntent(activity: Activity, visibility: Int) = activity.intentFor<MainActivity>(
            VISIBILITY to visibility
        )
    }

    @Inject
    @field:ViewModelInjection
    lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var visibilityFromIntent = intent.getIntExtra(VISIBILITY, GONE)
        initListeners()
        toast("Toast from Anko")
    }

    private fun initListeners() {
        binding.tvMain.setOnClickListener {
            startActivity(SecondActivity.getIntent(this, true))
        }

        binding.tvFragment.setOnClickListener {
//            val details = DetailFragment()
//            val ft = supportFragmentManager.beginTransaction()
//            details.setId(0)
//            ft.replace(R.id.fragmentContainer, details)
//            ft.addToBackStack(null)
//            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            ft.commit()
            if (binding.fragmentContainer.visibility == GONE) {
                binding.fragmentContainer.visibility = VISIBLE
            } else {
                binding.fragmentContainer.visibility = GONE
            }

            showDetailFragmentById(1)
        }
    }

    private fun showDetailFragmentById(id: Long) {
       supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, DetailFragment.newInstance(id))
            addToBackStack(null)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            commit()
        }
    }
}
