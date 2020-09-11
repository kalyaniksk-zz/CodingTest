package com.assignment.codingtest.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignment.codingtest.presentation.AssetViewModel
import com.assignment.codingtest.presentation.viewModel.ViewModelFactory
import com.assignment.codingtest.presentation.viewModel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AssetViewModel::class)
    internal abstract fun bindAssetViewModel(assetViewModel: AssetViewModel): ViewModel
}