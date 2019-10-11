package com.example.kotlinstudy.view.activity.loading

import com.example.kotlinstudy.base.BaseContract

interface LoadingContract {
    interface View: BaseContract.BaseView<Presenter>

    interface Presenter: BaseContract.BasePresenter {
        fun getAutoLogin():Boolean
    }
}