
package com.mytest.xiaoyu.binding.ext

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.app.Fragment
import android.os.Build
import android.os.Bundle
import androidx.lifecycle.BindingLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner


fun Lifecycle.observerWhenDestroyed(destroyed: () -> Unit) {
    addObserver(LifecycleObserver(lifecycle = this, destroyed = destroyed))
}

fun Lifecycle.observerWhenCreated(create: () -> Unit) {
    addObserver(LifecycleObserver(lifecycle = this, create = create))
}

class LifecycleObserver(
    var lifecycle: Lifecycle?,
    var destroyed: (() -> Unit)? = null,
    var create: (() -> Unit)? = null
) : BindingLifecycleObserver() {

    override fun onCreate(owner: LifecycleOwner?) {
        create?.invoke()
    }

    override fun onDestroy(owner: LifecycleOwner?) {
        destroyed?.invoke()
        lifecycle?.apply {
            removeObserver(this@LifecycleObserver)
            lifecycle = null
        }
        create = null
        destroyed = null
    }
}

fun Activity.observerWhenDestroyed(destroyed: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        registerActivityLifecycleCallbacks(LifecycleCallbacks(destroyed))
    }
}

class LifecycleCallbacks(var destroyed: (() -> Unit)? = null) :
    Application.ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        //not need to handle it
    }

    override fun onActivityStarted(activity: Activity) {
        //not need to handle it
    }

    override fun onActivityResumed(activity: Activity) {
        //not need to handle it
    }

    override fun onActivityPaused(activity: Activity) {
        //not need to handle it
    }

    override fun onActivityStopped(activity: Activity) {
        //not need to handle it
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        //not need to handle it
    }

    override fun onActivityDestroyed(activity: Activity) {
        destroyed?.invoke()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            activity.unregisterActivityLifecycleCallbacks(this)
        }
        destroyed = null
    }
}

class LifecycleFragment : Fragment {
    var destroyed: (() -> Unit)? = null

    constructor()

    @SuppressLint("ValidFragment")
    constructor(destroyed: () -> Unit) : this() {
        this.destroyed = destroyed
    }

    override fun onDestroy() {
        super.onDestroy()
        destroyed?.invoke()
        destroyed = null
    }
}
