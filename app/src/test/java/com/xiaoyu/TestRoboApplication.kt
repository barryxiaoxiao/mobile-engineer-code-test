package com.xiaoyu

import android.app.Activity
import android.app.Application
import android.app.Service
import androidx.fragment.app.Fragment
import dagger.android.*
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class TestRoboApplication : Application(), HasServiceInjector, HasActivityInjector,
    HasSupportFragmentInjector{

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var serviceDispatchingAndroidInjector: DispatchingAndroidInjector<Service>

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

    override fun serviceInjector(): AndroidInjector<Service> = serviceDispatchingAndroidInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerTestRoboApplicationComponent.builder().application(this).build().inject(this)
    }
}