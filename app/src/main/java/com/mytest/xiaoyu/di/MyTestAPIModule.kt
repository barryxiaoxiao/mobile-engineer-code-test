package com.mytest.xiaoyu.di

import com.mytest.xiaoyu.network.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Module responsible for API related dependencies
 */
@Module(includes = [RepositoryModuleBinds::class, ConnectivityModuleBinds::class])
class MyTestAPIModule {

    @Provides
    @Singleton
    fun provideSmartPadApiService(network: MyTestNetwork): MyTestApiService {
        val retrofit = network.retrofit.invoke()
        return retrofit.create(MyTestApiService::class.java)
    }

}

/**
 * Module responsible for binding the repository layer
 */
@Module
abstract class RepositoryModuleBinds {
    @Singleton
    @Binds
    abstract fun bindRepository(repo: MyTestRepositoryImpl): MyTestRepository
}

@Module
abstract class ConnectivityModuleBinds {
    @Singleton
    @Binds
    abstract fun bindConnectivityStatus(status: ConnectivityStatusImpl): ConnectivityStatus
}