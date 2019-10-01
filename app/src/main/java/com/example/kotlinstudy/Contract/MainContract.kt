package com.example.kotlinstudy.Contract

interface MainContract {
    interface View {
        fun setView()
    }

    interface Presenter {
        fun presenterView()
    }
}
