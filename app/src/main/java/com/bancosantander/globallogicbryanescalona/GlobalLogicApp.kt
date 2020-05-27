package com.bancosantander.globallogicbryanescalona

import android.app.Application
import com.bancosantander.globallogicbryanescalona.di.appModule
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

const val URL_BASE_API = "https://rickandmortyapi.com/"
const val DATABASE_NAME = "globalLogic.sqlite"
const val DATABASE_VERSION = 2
open class GlobalLogicApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        AndroidThreeTen.init(this)
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@GlobalLogicApp)
            modules(listOf(appModule))
        }
    }
}