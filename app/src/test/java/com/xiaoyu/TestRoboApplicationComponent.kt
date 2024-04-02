package com.xiaoyu

import com.hsbc.mobilebanking.cashinstallmentjourney.di.*
import com.xiaoyu.di.TestRoboAPIModule
import com.xiaoyu.di.TestRoboAppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        BindRoboTestActivityModule::class,
        TestRoboAPIModule::class,
        TestRoboAppModule::class]
)
interface TestRoboApplicationComponent : AndroidInjector<TestRoboApplication>{

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(roboApplication: TestRoboApplication): Builder
        fun build(): TestRoboApplicationComponent
    }
}