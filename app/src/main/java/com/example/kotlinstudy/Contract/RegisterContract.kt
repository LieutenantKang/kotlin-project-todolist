package com.example.kotlinstudy.Contract

import android.content.Intent

interface RegisterContract {
    interface Model{
        interface OnFinishedListener{
            fun onFinished(id: Int)
            fun onFailure(t : Throwable)
        }
        fun signUp(onFinishedListener: OnFinishedListener, email: String, pw: String, pwCheck: String)
    }

    interface View {
        fun setView()
        fun showToast(title: String)
        fun startIntent(intent: Intent)
    }

    interface Presenter {
        fun presenterView()
        fun signUp(email: String, pw: String, pwCheck: String)
    }
}
