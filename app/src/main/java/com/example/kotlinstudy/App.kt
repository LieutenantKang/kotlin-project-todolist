package com.example.kotlinstudy

import android.app.Application

class App: Application() {
    companion object {
        private var instance: App? = null

        fun getInstance(): App {
            if(instance == null)
                instance = App()

            return instance!!
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
}