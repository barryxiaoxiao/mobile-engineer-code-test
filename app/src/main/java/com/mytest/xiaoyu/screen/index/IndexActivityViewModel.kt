package com.mytest.xiaoyu.screen.index

import androidx.lifecycle.ViewModel
import com.mytest.xiaoyu.common.SingleLiveData
import com.mytest.xiaoyu.network.MyTestRepository

import javax.inject.Inject

class IndexActivityViewModel @Inject constructor(private val smartPadRepository: MyTestRepository) :
    ViewModel() {

}