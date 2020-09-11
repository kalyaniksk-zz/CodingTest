package com.assignment.codingtest


class MainFragmentRobot : BaseTestRobot() {
    fun matchRecyclerViewItem(text: String, position: Int) {
        checkRecyclerViewItemExists(R.id.assetDetailsRecycleView, text, position)
    }

    companion object {
        fun main(func: MainFragmentRobot.() -> Unit) = MainFragmentRobot()
                .apply { func() }
    }
}