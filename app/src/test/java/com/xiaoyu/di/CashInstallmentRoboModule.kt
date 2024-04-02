package com.hsbc.mobilebanking.cashinstallmentjourney.di

import com.hsbc.mobilebanking.cashinstallmentjourney.*
import com.hsbc.mobilebanking.cashinstallmentjourney.analytics.AnalyticsDelegate
import com.hsbc.mobilebanking.cashinstallmentjourney.model.config.CashInstallmentFeatureConfiguration
import com.hsbc.mobilebanking.cashinstallmentjourney.tds.TDSGlobalCallback
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CashInstallmentRoboModule {
    @Provides
    fun provideCashInstallmentGlobalCallback(): CashInstallmentGlobalCallback {
        return TestRoboCashInstallmentHolder.getInstance().cashInstallmentGlobalCallback
    }

    @Singleton
    @Provides
    fun provideCashInstallmentTDSGlobalCallback(): TDSGlobalCallback {
        return RoboTDSGlobalTestCallbackImpl()
    }

    @Provides
    fun provideCashInstallmentConfiguration(): CashInstallmentFeatureConfiguration {
        return TestRoboCashInstallmentHolder.getInstance().cashInstallmentFeatureConfiguration
    }

    @Provides
    fun provideNetworkCallbacks(): CashInstallmentNetworkCallback {
        return TestRoboCashInstallmentHolder.getInstance().cashInstallmentNetworkCallback
    }

    @Provides
    fun provideAnalytics():CashInstallmentAnalyticsCallBack= CashInstallmentRoboAnalyticsCallbackImpl()

    @Provides
    fun provideAnalyticsDelegate(): AnalyticsDelegate {
        return TestRoboCashInstallmentHolder.getInstance().analyticsDelegate
    }

    @Provides
    fun provideConnectivityStatus() = TestRoboCashInstallmentHolder.getInstance().connectivityStatus
}