package com.example.rayfield

import android.app.Application
import com.example.rayfield.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class RayFieldApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@RayFieldApp)
        }
    }
}
