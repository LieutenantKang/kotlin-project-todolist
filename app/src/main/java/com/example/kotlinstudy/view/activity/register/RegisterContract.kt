package com.example.kotlinstudy.view.activity.register

import com.example.kotlinstudy.base.BaseContract

interface RegisterContract {
    interface View: BaseContract.BaseView<Presenter> {
        fun showToastMessage(msg: String)

        fun passSignUp()
    }

    interface Presenter: BaseContract.BasePresenter {
        fun signUp(email: String, pw: String, pwCheck: String)
    }
}
