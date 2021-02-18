package com.block.note.presentation.base

import com.block.note.di.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class BaseActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
}