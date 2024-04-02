package com.mytest.xiaoyu.screen.index

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytest.xiaoyu.common.Constants
import com.mytest.xiaoyu.common.SingleLiveData
import com.mytest.xiaoyu.data.response.CurrencyResponse
import com.mytest.xiaoyu.data.response.CurrencyTotalResponse
import com.mytest.xiaoyu.network.MyTestRepository
import com.mytest.xiaoyu.network.MyTestResult
import kotlinx.coroutines.launch
import javax.inject.Inject

class IndexFragmentViewModel @Inject constructor(private val smartPadRepository: MyTestRepository) :
    ViewModel() {

    private val _currencyInfo = SingleLiveData<CurrencyResponse?>()
    val currencyInfo: SingleLiveData<CurrencyResponse?>
        get() = _currencyInfo

    private val _currencyInfoError = SingleLiveData<Exception?>()
    val currencyInfoError: SingleLiveData<Exception?>
        get() = _currencyInfoError


    private val _currencyTotalInfo = SingleLiveData<CurrencyTotalResponse?>()
    val currencyTotalInfo: SingleLiveData<CurrencyTotalResponse?>
        get() = _currencyTotalInfo

    private val _currencyTotalInfoError = SingleLiveData<Exception?>()
    val currencyTotalInfoError: SingleLiveData<Exception?>
        get() = _currencyTotalInfoError


    fun getIndexCurrencyInfo(userId: String) {
        viewModelScope.launch {
            smartPadRepository.getCurrencyDetailsByUserId(userId).let { indexInfo ->
                when (indexInfo) {
                    is MyTestResult.Success -> {
                        val result = indexInfo.data
                        if (result.code == Constants.SUCCESS_CODE)
                            _currencyInfo.value = indexInfo.data
                        else _currencyInfoError.value = Exception()
                    }
                    is MyTestResult.Error -> {
                        _currencyInfoError.value = indexInfo.exception
                    }
                }
            }
        }
    }


    fun getIndexCurrencyTotalInfo(userId: String) {
        viewModelScope.launch {
            smartPadRepository.getCurrencyTotalInfoByUserId(userId).let { indexInfo ->
                when (indexInfo) {
                    is MyTestResult.Success -> {
                        val result = indexInfo.data
                        if (result.code == Constants.SUCCESS_CODE)
                            _currencyTotalInfo.value = indexInfo.data
                        else _currencyTotalInfoError.value = Exception()
                    }
                    is MyTestResult.Error -> {
                        _currencyTotalInfoError.value = indexInfo.exception
                    }
                }
            }
        }
    }

}