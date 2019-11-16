package com.example.kotlinstudy.Contract

import android.content.Intent

interface LoginContract {
    interface Model{
        interface OnLoginFinishedListener{
            fun onFinished(token: String, autoLogin: Boolean)
            fun onFailure(t: Throwable)
        }
        fun login(onLoginFinishedListener: OnLoginFinishedListener, email: String, pw: String, autoLogin:Boolean)
    }

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
