package com.example.kotlinstudy

import android.app.Application
import com.example.kotlinstudy.data.room.UserDatabase

class App: Application() {
    companion object {
        lateinit var database: UserDatabase

        private var instance: App? = null

        fun getInstance(): App {
            if(instance == null)
                instance = App()

            return instance!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        database = UserDatabase.getInstance(App.getInstance().applicationContext)
    }
}