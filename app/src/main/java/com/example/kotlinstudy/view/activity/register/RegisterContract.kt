package com.example.kotlinstudy.view.activity.register

import android.content.Intent
import com.example.kotlinstudy.base.BaseContract

interface RegisterContract {
    interface View: BaseContract.BaseView<Presenter> {
        fun showToastMessage(msg: String)
    }

    interface Presenter: BaseContract.BasePresenter {
//        fun presenterView()
        fun signUp(email: String, pw: String, pwCheck: String)
    }
}
