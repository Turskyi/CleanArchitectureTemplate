package ua.turskyi.democleanarchitecture.features.second

import android.app.Activity
import android.os.Bundle
import android.view.View.GONE
import kotlinx.android.synthetic.main.activity_list.*
import org.jetbrains.anko.intentFor
import ua.turskyi.democleanarchitecture.R
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection
import ua.turskyi.democleanarchitecture.common.ui.base.BaseActivity
import ua.turskyi.democleanarchitecture.features.main.MainActivity
import ua.turskyi.democleanarchitecture.features.second.list.UserListFragment
import javax.inject.Inject

class SecondActivity : BaseActivity() {

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
    override fun layoutRes(): Int = R.layout.activity_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val act = intent.getBooleanExtra(IS_ACTIVATED, false)
        tvList.setOnClickListener {
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