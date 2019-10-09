package com.example.kotlinstudy.Contract

interface WriteContract {
    interface View{
        fun setView()
    }

    interface Presenter {
        fun presenterView()
    }
}