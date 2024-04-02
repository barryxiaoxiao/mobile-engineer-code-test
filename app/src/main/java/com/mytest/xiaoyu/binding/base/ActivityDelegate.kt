package com.mytest.xiaoyu.binding.base

import android.app.Activity
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.mytest.xiaoyu.binding.ext.LifecycleFragment
import com.mytest.xiaoyu.binding.ext.observerWhenDestroyed
import kotlin.properties.ReadOnlyProperty


abstract class ActivityDelegate<T : ViewBinding>(
    activity: Activity
) : ReadOnlyProperty<Activity, T> {

    protected var viewBinding: T? = null
    private val LIFECYCLE_FRAGMENT_TAG = "LIFECYCLE_FRAGMENT_TAG"

    init {
        when (activity) {
            is ComponentActivity -> activity.lifecycle.observerWhenDestroyed { destroyed() }
            else -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    activity.observerWhenDestroyed { destroyed() }
                }
            }
        }

    }

    fun addLifecycleFragment(activity: Activity) {
        if (activity is FragmentActivity || activity is AppCompatActivity) return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) return
        val fragmentManager = activity.fragmentManager
        if (fragmentManager.findFragmentByTag(LIFECYCLE_FRAGMENT_TAG) == null) {
            val transaction = fragmentManager.beginTransaction()
            transaction.add(LifecycleFragment { destroyed() }, LIFECYCLE_FRAGMENT_TAG).commitAllowingStateLoss()
            fragmentManager.executePendingTransactions()
        }
    }

    private fun destroyed() {
        viewBinding = null
    }
}