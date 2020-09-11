package com.assignment.codingtest.util

import android.view.View
import androidx.test.espresso.IdlingResource

/**
 * Idling resource notifies when the view becomes visible.
 */
class ViewVisibilityIdlingResource(private val view: View, private val expectedVisibility: Int) : IdlingResource {
    private var isIdle: Boolean = false
    private var resourceCallback: IdlingResource.ResourceCallback? = null

    override fun getName(): String {
        return ViewVisibilityIdlingResource::class.java.simpleName
    }

    override fun isIdleNow(): Boolean {
        isIdle = isIdle || view.visibility == expectedVisibility

        if (isIdle) {
            resourceCallback?.onTransitionToIdle()
        }

        return isIdle
    }

    init {
        this.isIdle = false
        this.resourceCallback = null
    }

    override fun registerIdleTransitionCallback(resourceCallback: IdlingResource.ResourceCallback) {
        this.resourceCallback = resourceCallback
    }

}