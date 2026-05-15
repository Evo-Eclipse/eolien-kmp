package com.example.rayfield.di

import com.example.rayfield.data.database.AppDatabase
import com.example.rayfield.data.database.getRoomDatabase
import com.example.rayfield.ui.state.MainScreenModel
import com.example.rayfield.ui.state.configuration.SshScreenModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(commonModule, platformModule)
    }
}

val commonModule = module {
    single { getRoomDatabase(get()) }
    single { get<AppDatabase>().serverDao() }
    factory { MainScreenModel(get()) }
    factory { (serverId: String?) ->
        SshScreenModel(
            serverDao = get(),
            initialServerId = serverId
        )
    }}

expect val platformModule: Module
