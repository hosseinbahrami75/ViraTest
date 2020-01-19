package com.android.vira

import android.app.Application
import android.content.Context


/**
 *  Created by HosseinBahrami at 1/19/2020

 *  this class is used for per-process initialization that should always happen, not just for certain activities or other components.
So, for example, you might initialize:
-Dependency injection (e.g., Dagger)
-Crash logging (e.g., ACRA)
-Diagnostic tools (e.g., LeakCanary, Stetho, Sonar)
-Global pools (e.g., OkHttpClient)
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        context = this
    }


    fun getContext(): Context? {
        return context
    }

    companion object {

        @get:Synchronized
        var instance: App? = null
        private var context: Context? = null
    }
}
