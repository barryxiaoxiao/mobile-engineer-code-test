package com.xiaoyu.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xiaoyu.viewmodelfactory.RoboTestViewModelFactory
import com.hsbc.mobilebanking.cashinstallmentjourney.viewmodelfactory.ViewModelKey
import com.mytest.xiaoyu.screen.index.IndexActivityViewModel
import com.mytest.xiaoyu.screen.index.IndexFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class RoboTestViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: RoboTestViewModelFactory): ViewModelProvider.Factory

    /**
     * Multi-bind the view model into a map
     */
    @Binds
    @IntoMap
    @ViewModelKey(IndexActivityViewModel::class)
    internal abstract fun indexActivityViewModel(viewModel: IndexActivityViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(IndexFragmentViewModel::class)
    internal abstract fun bindIndexFragmentViewModel(viewModel: IndexFragmentViewModel): ViewModel

}
