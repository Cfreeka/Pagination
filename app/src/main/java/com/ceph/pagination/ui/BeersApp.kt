package com.ceph.pagination.ui

import android.app.Application
import com.ceph.pagination.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class BeersApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BeersApp)
            modules(appModule)
        }
    }
}