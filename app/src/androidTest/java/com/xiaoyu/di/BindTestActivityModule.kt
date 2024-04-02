package com.xiaoyu.di

import com.mytest.xiaoyu.screen.index.IndexActivity
import com.mytest.xiaoyu.screen.index.IndexFragment
import com.xiaoyu.TestActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        TestViewModelModule::class
    ]
)
internal abstract class BindTestActivityModule {
    @ContributesAndroidInjector
    abstract fun bindTestActivity(): TestActivity

    /*** Journey UI injection consumer bindings ***/
    @ContributesAndroidInjector
    internal abstract fun contributeIndexActivity(): IndexActivity

    @ContributesAndroidInjector
    internal abstract fun contributeIndexFragment(): IndexFragment


}