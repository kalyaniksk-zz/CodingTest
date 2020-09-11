package com.assignment.codingtest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.assignment.codingtest.util.Matchers.atPosition


open class BaseTestRobot {

    fun checkRecyclerViewItemExists(recyclerViewId: Int, text: String, position: Int) {
        onView(withId(recyclerViewId))
                .check(matches(atPosition(position, hasDescendant(withText(text)))))
    }

}