package com.example.kotlinstudy.view.activity.login

import com.example.kotlinstudy.base.BaseContract

interface LoginContract {
    interface View: BaseContract.BaseView<Presenter> {
        fun showEmail(email: String)
    }

    interface Presenter: BaseContract.BasePresenter {
//        fun presenterView()
        fun login(email: String, pw: String, autoLogin:Boolean)
        fun getEmail(): String
    }
}
