package com.mytest.xiaoyu.data.response

data class CurrencyTotalResponse(val msg: CurrencyTotal, val code: Int)

data class CurrencyTotal(
    val currencyTotal: CurrencyTotalInfo
)

data class CurrencyTotalInfo(
    val equity: String,
    val balance: String,
    val margin: String,
    val used: String
)
