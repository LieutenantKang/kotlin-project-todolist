package com.example.kotlinstudy.view.activity.write

import com.example.kotlinstudy.base.BaseContract

interface WriteContract {
    interface View: BaseContract.BaseView<Presenter> {
//        fun setView()
    }

    interface Presenter: BaseContract.BasePresenter {
//        fun presenterView()
    }
}