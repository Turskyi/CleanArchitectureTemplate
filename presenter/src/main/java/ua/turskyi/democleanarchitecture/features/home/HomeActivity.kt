package ua.turskyi.democleanarchitecture.features.home

import android.app.Activity
import android.os.Bundle
import android.view.View.GONE
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.intentFor
import ua.turskyi.democleanarchitecture.R
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection
import ua.turskyi.democleanarchitecture.common.ui.base.BaseActivity
import ua.turskyi.democleanarchitecture.features.main.MainActivity
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    companion object {
        private const val IS_ACTIVATED = "is_activated"
        fun getIntent(activity: Activity, isActivated: Boolean) = activity.intentFor<HomeActivity>(
            IS_ACTIVATED to isActivated
        )
    }

    @Inject
    @field:ViewModelInjection
    lateinit var activityVM: HomeActivityVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

      val act =  intent.getBooleanExtra(IS_ACTIVATED, false)

        tvHome.setOnClickListener {
            startActivity(MainActivity.getIntent(this, GONE))
        }
    }
}