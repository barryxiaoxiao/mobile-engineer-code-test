package com.xiaoyu

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import javax.inject.Inject

class TestRoboActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.cip_activity_test)
        setToolBar()
        hostViewModel =
            ViewModelProvider(this.viewModelStore, viewModelFactory)[ViewModel::class.java]

        hostViewModel.storeAccountData(Account(
                accountDisplay = "5512 1234 4567 2004",
                productCode = "productCode",
                productShortName = "HSBC Visa Signature Card",
                accountIdentifier = "MockAccountIdentifier"
            )
        )
        hostViewModel.setFromAccount(
            accountCardNumber = "5512 1234 4567 2004",
            accountName = "HSBC Visa Signature Card"
        )
        hostViewModel.setReceivingAccount(
            TestRoboCashInstallmentHolder.getInstance().receivingAccountModel
        )
        hostViewModel.setConfirmPlanData(confirmPlanModel = TestRoboCashInstallmentHolder.getInstance().confirmPlanData)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.cip_menu_main, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.findItem(R.id.ic_info_menu)?.title = getString(R.string.cip_about_title)
        return super.onPrepareOptionsMenu(menu)
    }

    private fun setToolBar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
}