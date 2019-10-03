package com.example.kotlinstudy.Contract

interface LoadingContract {
    interface View{
        fun setView()
    }

    interface Presenter {
        fun getAutoLogin():Boolean?
    }
}