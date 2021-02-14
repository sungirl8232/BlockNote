package com.block.note.presentation

import android.app.Application
import com.block.note.di.component.AppComponent
import com.block.note.di.component.DaggerAppComponent
import com.block.note.di.module.ViewModelModule

class App : Application() {

    lateinit var applicationComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerAppComponent.builder()
            .viewModelModule(ViewModelModule())
            .build()
        applicationComponent.inject(this)
    }
}