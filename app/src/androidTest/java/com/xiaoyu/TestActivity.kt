package com.xiaoyu

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.os.LocaleList
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import java.util.Locale
import javax.inject.Inject

class TestActivity  : AppCompatActivity(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun attachBaseContext(base: Context) {


    }

    private fun updateResource(oldContext: Context, locale: Locale): Context {
        val configuration = oldContext.resources.configuration

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            configuration.setLocale(locale)

            val localeList = LocaleList(locale)
            LocaleList.setDefault(localeList)
            configuration.setLocales(localeList)
            setUpResourceConfigurations(oldContext,configuration)
        } else {
            Locale.setDefault(locale)
            configuration.setLocale(locale)
            setUpResourceConfigurations(oldContext,configuration)
        }
    }

    private fun setUpResourceConfigurations(
        oldContext: Context,
        configuration: Configuration
    ): Context {
        return oldContext.createConfigurationContext(configuration)
    }

    override fun applyOverrideConfiguration(overrideConfiguration: Configuration) {

    }

    private fun updateConfigurationIfSupported(
        config: Configuration,
        locale: Locale
    ): Configuration {
        if (!hasLocale(config)) {
            config.setLocale(locale)
        }
        return config
    }

    private fun hasLocale(config: Configuration): Boolean {
        // Configuration.getLocales is added after 24 and Configuration.locale is deprecated in 24

        return if (Build.VERSION.SDK_INT >= 24) {
            !config.locales.isEmpty
        } else {
            config.locale != null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        val frameLayout = FrameLayout(this)
        frameLayout.id = R.id.nav_host_fragment
        setContentView(R.layout.cip_activity_test)
        setupViewModel()
        setToolBar()
    }

    private fun setupViewModel() {

    private fun setToolBar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}