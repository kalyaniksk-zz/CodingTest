package com.assignment.codingtest

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.rule.ActivityTestRule
import com.assignment.codingtest.MainFragmentRobot.Companion.main
import com.assignment.codingtest.util.ViewVisibilityIdlingResource
import com.assignment.codingtest.presentation.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/**
 * Instrumented test, which will execute on an Android device.
 **/
class MainInstrumentedTest {

    lateinit var context: Context
    lateinit var idlingResource : IdlingResource

    @Rule @JvmField
    var mActivityRule = ActivityTestRule(MainActivity::class.java)
    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext<Context>()
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        activityScenario.onActivity { activity ->
            val view = activity.findViewById<RecyclerView>(R.id.assetDetailsRecycleView)
            idlingResource = ViewVisibilityIdlingResource(view, View.VISIBLE)
        }
    }

    @Test
    fun testMainFragment() {
        main {
            IdlingRegistry.getInstance().register(idlingResource)
            /*UI testing for recycle view first item with byline field
            * */
            matchRecyclerViewItem("Sally Patten", 0)
            /* UI testing for recycle view second item with Headline field
            * */
            matchRecyclerViewItem("Never mind freedom, Ant IPO wants Hong Kong to feel the wealth", 1)
            /* UI testing for recycle view second item with Abstract field
            * */
            matchRecyclerViewItem("Big six law firm Herbert Smith Freehills only expects its staff to be in the office for 60 per cent of the week under a new global flexible work policy, as the legal industry leaves its COVID-19 pay cuts behind.", 2)
            IdlingRegistry.getInstance().unregister(idlingResource)
        }
    }




}
