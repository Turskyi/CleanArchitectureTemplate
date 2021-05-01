package ua.turskyi.democleanarchitecture.features.second

import android.app.Activity
import android.os.Bundle
import android.view.View.GONE
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.intentFor
import ua.turskyi.democleanarchitecture.R
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection
import ua.turskyi.democleanarchitecture.databinding.ActivitySecondBinding
import ua.turskyi.democleanarchitecture.features.main.MainActivity
import ua.turskyi.democleanarchitecture.features.second.list.UserListFragment
import javax.inject.Inject

class SecondActivity : DaggerAppCompatActivity() {

    companion object {
        private const val IS_ACTIVATED = "is_activated"
        fun getIntent(activity: Activity, isActivated: Boolean) =
            activity.intentFor<SecondActivity>(
                IS_ACTIVATED to isActivated
            )
    }

    @Inject
    @field:ViewModelInjection
    lateinit var activityVM: SecondActivityVM
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val act = intent.getBooleanExtra(IS_ACTIVATED, false)
        binding.tvList.setOnClickListener {
            startActivity(MainActivity.getIntent(this, GONE))
        }

        showListFragment()

    }

    private fun showListFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.listContainer, UserListFragment.newInstance())
        ft.commit()
    }
}