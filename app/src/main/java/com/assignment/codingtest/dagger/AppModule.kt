package com.assignment.codingtest.dagger

import android.app.Application
import com.assignment.codingtest.presentation.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun providesApplication(application: BaseApplication): Application {
        return application
    }

}