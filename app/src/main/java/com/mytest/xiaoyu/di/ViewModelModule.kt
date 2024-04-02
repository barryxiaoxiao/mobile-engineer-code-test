package com.mytest.xiaoyu.di


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mytest.xiaoyu.screen.index.IndexActivityViewModel
import com.mytest.xiaoyu.screen.index.IndexFragmentViewModel
import com.mytest.xiaoyu.viewmodel.ViewModelFactory
import com.mytest.xiaoyu.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(IndexActivityViewModel::class)
    internal abstract fun bindIndexActivityViewModel(viewModel: IndexActivityViewModel):ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(IndexFragmentViewModel::class)
    internal abstract fun bindIndexFragmentViewModel(viewModel: IndexFragmentViewModel):ViewModel


}
