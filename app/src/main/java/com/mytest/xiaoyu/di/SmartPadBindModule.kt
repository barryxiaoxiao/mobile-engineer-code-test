package com.mytest.xiaoyu.di

import com.mytest.xiaoyu.screen.index.IndexActivity
import com.mytest.xiaoyu.screen.index.IndexFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [MyTestAPIModule::class])
abstract class SmartPadBindModule {

    @ContributesAndroidInjector
    internal abstract fun bindIndexActivity(): IndexActivity

    @ContributesAndroidInjector
    internal abstract fun bindIndexFragment(): IndexFragment

}