package com.mytest.xiaoyu.di

import android.app.Application
import android.content.Context
import com.mytest.xiaoyu.application.SmartPadApplication
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideContext(sampleApplication: SmartPadApplication): Context

    @Binds
    @Singleton
    abstract fun provideApplication(sampleApplication: SmartPadApplication): Application
}