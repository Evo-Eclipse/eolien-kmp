package com.example.rayfield.di

import com.example.rayfield.data.database.getDatabaseBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single { getDatabaseBuilder(androidContext()) }
}
