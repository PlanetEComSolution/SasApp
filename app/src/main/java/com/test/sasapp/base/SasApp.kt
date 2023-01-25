package com.test.sasapp.base

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

class SasApp: Application() {

    companion object {
        lateinit var instance: SasApp
            private set
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this


    }
}