package com.example.kotlinstudy.Contract

import android.content.Intent

interface RegisterContract {
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
