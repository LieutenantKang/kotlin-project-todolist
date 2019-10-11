package com.example.kotlinstudy.view.activity.register

import com.example.kotlinstudy.data.model.UserModel

class RegisterPresenter(private val view: RegisterContract.View) : RegisterContract.Presenter {

    private val userModel: UserModel by lazy { UserModel() }

    override fun start() {
        view.presenter = this
    }

    override fun signUp(email: String, pw: String, pwCheck: String) {
        view.getResult(userModel.signUp(email, pw, pwCheck))
    }
}
