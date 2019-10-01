package com.example.kotlinstudy.Interface

interface RegisterInterface {
    interface View {
        fun setView()
        fun showToast(title: String)
    }

    interface Presenter {
        fun presenterView()
        fun signUp(email: String, pw: String, pwCheck: String)
    }
}
