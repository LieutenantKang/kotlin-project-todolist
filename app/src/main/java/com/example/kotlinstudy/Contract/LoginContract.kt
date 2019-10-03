package com.example.kotlinstudy.Contract

interface LoginContract {
    interface View {
        fun setView()
        fun showToast(title: String)
    }

    interface Presenter {
        fun presenterView()
        fun login(email: String, pw: String, autoLogin:Boolean)
        fun showEmail():String?
    }
}
