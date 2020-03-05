package ua.turskyi.democleanarchitecture.features.main

import android.os.Bundle
import ua.turskyi.democleanarchitecture.R
import ua.turskyi.democleanarchitecture.common.di.qualifiers.ViewModelInjection
import ua.turskyi.democleanarchitecture.common.ui.base.BaseActivity
import javax.inject.Inject

// TODO: 5
class MainActivity : BaseActivity() {

    @Inject
    @field:ViewModelInjection
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
