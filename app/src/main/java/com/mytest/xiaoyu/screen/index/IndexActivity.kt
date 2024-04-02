package com.mytest.xiaoyu.screen.index


import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.mytest.xiaoyu.R
import com.mytest.xiaoyu.binding.ext.viewBind
import com.mytest.xiaoyu.databinding.ActivityIndexBinding
import com.mytest.xiaoyu.screen.base.BaseActivity
import com.mytest.xiaoyu.viewmodel.ViewModelFactory
import javax.inject.Inject


class IndexActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: IndexActivityViewModel
    private val binding: ActivityIndexBinding by viewBind()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViewModel(
            ViewModelProvider(
                this.viewModelStore,
                viewModelFactory
            )[IndexActivityViewModel::class.java]
        )
        initView()

    }


    private fun initView() {
        supportFragmentManager.beginTransaction().replace(R.id.container, IndexFragment()).commit()
    }


    private fun setupViewModel(vm: IndexActivityViewModel) {
        viewModel = vm
    }

}

















