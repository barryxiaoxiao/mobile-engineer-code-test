package com.xiaoyu

import com.xiaoyu.di.BindTestActivityModule
import com.xiaoyu.di.TestAPIModule
import com.xiaoyu.di.TestAppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
            BindTestActivityModule::class,
            TestAPIModule::class,
            TestAppModule::class])
interface TestApplicationComponent {
    fun inject(application: TestApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: TestApplication): Builder
        fun build(): TestApplicationComponent
    }
}