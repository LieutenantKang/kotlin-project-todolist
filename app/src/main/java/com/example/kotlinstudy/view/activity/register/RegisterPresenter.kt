package com.example.kotlinstudy.view.activity.register

import com.example.kotlinstudy.data.model.RegisterModel

class RegisterPresenter(private val view: RegisterContract.View) : RegisterContract.Presenter {

    private val userModel by lazy { RegisterModel() }

    override fun start() {
        view.presenter = this
    }

    override fun signUp(email: String, pw: String, pwCheck: String) {
        if(userModel.isPossibleEmail(email)) {
            if(userModel.isConfirmPw(pw, pwCheck)) {
                userModel.signUp(email, pw)
                view.passSignUp()
            } else {
                view.showToastMessage("비밀번호가 맞지 않습니다.")
            }
        } else {
            view.showToastMessage("중복된 아이디")
        }
    }
}
