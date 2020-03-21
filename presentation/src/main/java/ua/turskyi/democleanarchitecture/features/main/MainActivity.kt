package ua.turskyi.democleanarchitecture.features.main

import android.app.Activity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import ua.turskyi.democleanarchitecture.R
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection
import ua.turskyi.democleanarchitecture.common.ui.base.BaseActivity
import ua.turskyi.democleanarchitecture.features.second.SecondActivity
import ua.turskyi.democleanarchitecture.features.main.detail.DetailFragment
import javax.inject.Inject

// TODO: 5
class MainActivity : BaseActivity() {

    companion object {
        const val VISIBILITY = "visibility"
        fun getIntent(activity: Activity, visibility: Int) = activity.intentFor<MainActivity>(
            VISIBILITY to visibility
        )
    }

    @Inject
    @field:ViewModelInjection
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var visibilityFromIntent = intent.getIntExtra(VISIBILITY, GONE)

        initListeners()
    }

    private fun initListeners() {
        tvMain.setOnClickListener {
            startActivity(SecondActivity.getIntent(this, true))
        }

        tvFragment.setOnClickListener {
//            val details = DetailFragment()
//            val ft = supportFragmentManager.beginTransaction()
//            details.setId(0)
//            ft.replace(R.id.fragmentContainer, details)
//            ft.addToBackStack(null)
//            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            ft.commit()
            if (fragmentContainer.visibility == GONE) {
                fragmentContainer.visibility = VISIBLE
            } else {
                fragmentContainer.visibility = GONE
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
