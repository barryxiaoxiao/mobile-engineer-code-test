package com.mytest.xiaoyu.application

import android.app.Application
import android.content.Context
import com.mytest.xiaoyu.extensions.setUpDependencyInjection
import com.mytest.xiaoyu.greendao.database.DaoMaster
import com.mytest.xiaoyu.greendao.database.DaoSession
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class SmartPadApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
    lateinit var daoSession: DaoSession
    companion object {
        lateinit var application: SmartPadApplication
        lateinit var appContext: Context

        fun getInstance(): SmartPadApplication {
            return application
        }
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        setUpDependencyInjection()
        appContext = applicationContext
        initDataBase()
    }


    private fun initDataBase() {
        val daoMaster = DaoMaster(DaoMaster.DevOpenHelper(this, "MyTest.db").writableDatabase);
        daoSession = daoMaster.newSession()
    }

}