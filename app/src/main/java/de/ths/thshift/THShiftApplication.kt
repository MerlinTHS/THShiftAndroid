package de.ths.thshift

import android.app.Application
import de.ths.thshift.config.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class THShiftApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@THShiftApplication)

            modules(AppModule)
        }
    }
}