package com.mytest.xiaoyu.extensions

import android.app.Application
import com.mytest.xiaoyu.application.SmartPadApplication
import com.mytest.xiaoyu.di.ApplicationComponent
import com.mytest.xiaoyu.di.DaggerApplicationComponent


fun Application.setUpDependencyInjection(){
    val component = initDI(this)
    component.inject(this as SmartPadApplication)
}

private fun initDI(application: Application): ApplicationComponent {
    return DaggerApplicationComponent.builder()
        .application(application as SmartPadApplication)
        .build()
}