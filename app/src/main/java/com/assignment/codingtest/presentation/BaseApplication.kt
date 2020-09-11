package com.assignment.codingtest.presentation


import com.assignment.codingtest.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class BaseApplication : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        var appComponent = DaggerAppComponent.builder().application(this).build()
        return appComponent
    }


}
