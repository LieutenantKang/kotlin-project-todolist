package com.example.kotlinstudy.Contract

import android.content.Intent

interface LoginContract {
    interface View {
        fun setView()
        fun showToast(title: String)
        fun startIntent(intent: Intent)
    }

    interface Presenter {
        fun presenterView()
        fun login(email: String, pw: String, autoLogin:Boolean)
        fun showEmail():String?
    }
}
