package com.xiaoyu.di

import android.app.Application
import android.content.Context
import com.xiaoyu.TestRoboApplication
import dagger.Module
import dagger.Provides

@Module
class TestRoboAppModule {
    @Provides
    fun provideContext(roboApplication: TestRoboApplication): Context {
        return roboApplication
    }

    @Provides
    fun provideApplication(roboApplication: TestRoboApplication): Application {
        return roboApplication
    }
}