package com.example.kotlinstudy.base

interface BaseContract {
    interface BasePresenter {
        fun start()

//    val remoteSource: RemoteSource
//        get() = RemoteSource
    }

    interface BaseView<T> {
        var presenter: T

        fun isViewActive(): Boolean
    }
}