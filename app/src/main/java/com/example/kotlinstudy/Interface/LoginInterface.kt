package com.example.kotlinstudy.Interface

interface LoginInterface {
    interface View {
        fun setView()
        fun showToast(title: String)
    }

    interface Presenter {
        fun presenterView()
        fun Login(email: String, pw: String)
    }
}
