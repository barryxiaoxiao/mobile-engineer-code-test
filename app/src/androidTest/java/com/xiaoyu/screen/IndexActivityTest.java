package com.xiaoyu.screen;

import com.mytest.xiaoyu.screen.index.IndexActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import kotlin.jvm.JvmField;

public class IndexActivityTest {


    @Rule
    @JvmField
    val myActivityTestRule =
            ActivityTestRule<IndexActivity>(
                    IndexActivity::class.java, false, false
            )

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun testDisPlay() {
        coEvery { connectivityStatus.isConnected() } answers { true }
        myActivityTestRule.launchActivity(Intent()))
    }

    @Test
    fun testConnectivityFailedRetry() {
        coEvery { connectivityStatus.isConnected() } answers { false }
        myActivityTestRule.launchActivity(Intent())
        ViewIdlingResource.waitUntilIdleMatcherIsFulfilled(withId(R.id.errorView), isDisplayed())
        coEvery { connectivityStatus.isConnected() } answers { true }
        onView(
                Matchers.allOf(
                        withId(R.id.),
                        ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)
                )
        ).perform(
                ViewActions.click()
        )
    }
}
