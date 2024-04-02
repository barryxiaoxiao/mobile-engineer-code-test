package com.mytest.xiaoyu.di


import com.mytest.xiaoyu.network.ConnectivityStatus
import com.mytest.xiaoyu.network.MyTestNetwork
import com.mytest.xiaoyu.network.MyTestNetworkImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class SmartPadModule {

    @Provides
    @Singleton
    fun provideNetwork(connectivityStatus: ConnectivityStatus): MyTestNetwork =
        MyTestNetworkImpl(connectivityStatus)

}