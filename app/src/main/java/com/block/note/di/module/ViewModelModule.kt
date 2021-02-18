package com.block.note.di.module

import androidx.lifecycle.ViewModelProvider
import com.block.note.di.ViewModelFactory
import com.block.note.presentation.feature.list.NoteListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Provides
    fun getNoteListViewModule(): NoteListViewModel {
       return NoteListViewModel()
    }
}