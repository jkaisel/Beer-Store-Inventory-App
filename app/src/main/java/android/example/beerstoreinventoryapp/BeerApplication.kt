package android.example.beerstoreinventoryapp

import android.app.Application
import timber.log.Timber

class BeerApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}