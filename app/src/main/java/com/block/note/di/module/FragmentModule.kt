package com.block.note.di.module

import com.block.note.presentation.feature.list.NoteListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeNoteListFragment(): NoteListFragment
}