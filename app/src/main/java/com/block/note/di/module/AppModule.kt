package com.block.note.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var application: Application) {
    var applicationInstance = application


    @Provides
    @Singleton
    fun provideApplication(): Application {
        return applicationInstance
    }
}