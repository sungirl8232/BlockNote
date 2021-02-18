package com.block.note.presentation.base

import com.block.note.di.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class BaseFragment: DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
}