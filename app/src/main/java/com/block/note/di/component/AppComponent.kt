package com.block.note.di.component

import com.block.note.di.module.AppModule
import com.block.note.di.module.ViewModelModule
import com.block.note.presentation.App
import dagger.Component

@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(app: App)

}