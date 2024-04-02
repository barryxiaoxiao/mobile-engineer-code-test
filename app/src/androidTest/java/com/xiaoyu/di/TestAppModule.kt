package com.xiaoyu.di

import android.app.Application
import android.content.Context
import com.xiaoyu.TestApplication
import dagger.Module
import dagger.Provides

@Module
class TestAppModule {
    @Provides
    fun provideContext(application: TestApplication): Context {
        return application
    }

    @Provides
    fun provideApplication(application: TestApplication): Application {
        return application
    }
}