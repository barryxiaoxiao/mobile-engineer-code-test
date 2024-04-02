package com.mytest.xiaoyu.screen.index


import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mytest.xiaoyu.R
import com.mytest.xiaoyu.binding.ext.viewBind
import com.mytest.xiaoyu.data.response.CurrencyTotalInfo
import com.mytest.xiaoyu.databinding.FragmentIndexBinding
import com.mytest.xiaoyu.greendao.database.CurrencyDetail
import com.mytest.xiaoyu.screen.base.BaseFragment
import com.mytest.xiaoyu.screen.index.adapter.CurrencyDetailListAdapter
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.fixedRateTimer

class IndexFragment : BaseFragment(R.layout.fragment_index) {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: IndexFragmentViewModel
    private val binding: FragmentIndexBinding by viewBind()

    private var refreshTimer: Timer? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel(
            ViewModelProvider(
                this.viewModelStore,
                viewModelFactory
            )[IndexFragmentViewModel::class.java]
        )
        initData()
    }

    private var count = 0

    private fun initData() {
        refreshTimer = fixedRateTimer("refresh", false, 0, 10000L)
        {
            count++
            viewModel.getIndexCurrencyInfo("10001")
            viewModel.getIndexCurrencyTotalInfo("10001")
        }


    }


    private fun setupViewModel(vm: IndexFragmentViewModel) {
        viewModel = vm
        setUpObserver()
    }


    private fun setUpObserver() {
        viewModel.currencyInfo.observe(viewLifecycleOwner) { currencyInfo ->
            currencyInfo?.let {
                initCurrencyInfo()
            }
        }
        viewModel.currencyInfoError.observe(viewLifecycleOwner) {
            //should handle error case, now use mock
            if(count%2 == 0)
            initView()
            else initView1()
        }

        viewModel.currencyTotalInfo.observe(viewLifecycleOwner) { currencyInfo ->
            currencyInfo?.let {
                initCurrencyTotalInfo()
            }
        }
        viewModel.currencyTotalInfoError.observe(viewLifecycleOwner) {
            //should handle error case, now use mock
            if(count%2 == 0)
                initCurrencyTotalInfo()
            else initCurrencyTotalInfo1()
        }

    }

    private fun initCurrencyTotalInfo() {
        initTotalView()
    }

    private fun initCurrencyTotalInfo1() {
        initTotalView1()
    }

    private fun initTotalView() {
        //mock data
        val mockTotalInfo = CurrencyTotalInfo("$2,285,575.92", "$70,000.00", "$9,971.92", "$13.17")
        with(binding) {
            equity.text = mockTotalInfo.equity
            balance.text = mockTotalInfo.balance
            margin.text = mockTotalInfo.margin
            used.text = mockTotalInfo.used
        }
    }

    private fun initTotalView1() {
        //mock data
        val mockTotalInfo = CurrencyTotalInfo("$1,285,575.92", "$10,000.00", "$1,971.92", "$11.17")
        with(binding) {
            equity.text = mockTotalInfo.equity
            balance.text = mockTotalInfo.balance
            margin.text = mockTotalInfo.margin
            used.text = mockTotalInfo.used
        }
    }

    private fun initCurrencyInfo() {
        //should use API response ,now use the mock
        initView()
    }

    private fun initCurrencyInfo1() {
        //should use API response ,now use the mock
        initView1()
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.currencyList.apply {
            this.layoutManager = layoutManager
            adapter = CurrencyDetailListAdapter(getMockData())
        }
    }

    private fun initView1() {
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.currencyList.apply {
            this.layoutManager = layoutManager
            adapter = CurrencyDetailListAdapter(getMockData1())
        }
    }

    private fun getMockData(): List<CurrencyDetail> {
        val currencyDetails = mutableListOf<CurrencyDetail>()
        currencyDetails.add(CurrencyDetail(1L, "GBP/USD", "0.001%", "1.180", "1.443"))
        currencyDetails.add(CurrencyDetail(2L, "EUR/USD", "0.002%", "1.181", "1.444"))
        currencyDetails.add(CurrencyDetail(3L, "GPY/USD", "0.003%", "1.182", "1.445"))
        currencyDetails.add(CurrencyDetail(4L, "AUD/USD", "0.004%", "1.183", "1.446"))
        currencyDetails.add(CurrencyDetail(5L, "NZD/USD", "0.005%", "1.184", "1.447"))
        currencyDetails.add(CurrencyDetail(6L, "CAD/USD", "0.006%", "1.185", "1.448"))
        currencyDetails.add(CurrencyDetail(7L, "CNY/USD", "0.007%", "1.186", "1.449"))
        currencyDetails.add(CurrencyDetail(8L, "JAN/USD", "0.008%", "1.187", "1.449"))
        return currencyDetails
    }

    private fun getMockData1(): List<CurrencyDetail> {
        val currencyDetails = mutableListOf<CurrencyDetail>()
        currencyDetails.add(CurrencyDetail(11L, "GBP/USD", "0.101%", "1.110", "1.143"))
        currencyDetails.add(CurrencyDetail(21L, "EUR/USD", "0.102%", "1.111", "1.144"))
        currencyDetails.add(CurrencyDetail(31L, "GPY/USD", "0.103%", "1.112", "1.145"))
        currencyDetails.add(CurrencyDetail(41L, "AUD/USD", "0.104%", "1.113", "1.146"))
        currencyDetails.add(CurrencyDetail(51L, "NZD/USD", "0.105%", "1.114", "1.147"))
        currencyDetails.add(CurrencyDetail(61L, "CAD/USD", "0.106%", "1.115", "1.148"))
        currencyDetails.add(CurrencyDetail(71L, "CNY/USD", "0.107%", "1.116", "1.149"))
        currencyDetails.add(CurrencyDetail(81L, "JAN/USD", "0.108%", "1.117", "1.149"))
        return currencyDetails
    }

    override fun onDestroy() {
        super.onDestroy()
        refreshTimer?.cancel()
    }

}


