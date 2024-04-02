package com.mytest.xiaoyu.di

import com.mytest.xiaoyu.application.SmartPadApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    SmartPadModule::class,
    ViewModelModule::class,
    SmartPadBindModule::class
])
interface ApplicationComponent : AndroidInjector<SmartPadApplication>{

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: SmartPadApplication): Builder
        fun build(): ApplicationComponent
    }
}