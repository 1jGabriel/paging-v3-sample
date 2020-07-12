package io.jgabriel.pagingv3

import android.app.Application
import io.jgabriel.pagingv3.di.appModule
import io.jgabriel.pagingv3.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(appModule, networkModule))
        }
    }
}
