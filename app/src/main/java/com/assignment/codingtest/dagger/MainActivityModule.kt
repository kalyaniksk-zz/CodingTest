package com.assignment.codingtest.dagger

import com.assignment.codingtest.presentation.AssetListFragment
import com.assignment.codingtest.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun provideMainFragment(): AssetListFragment


}