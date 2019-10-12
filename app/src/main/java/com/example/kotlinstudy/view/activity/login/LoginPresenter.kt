package com.example.kotlinstudy.view.activity.login

import com.example.kotlinstudy.data.model.LoginModel

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {

    private val model: LoginModel by lazy { LoginModel() }

    override fun start() {
        view.presenter = this
    }

//    private val userModel: RegisterModel = RegisterModel(context)

//    override fun presenterView() {
//        view.setView()
//    }

    override fun login(email: String, pw: String, autoLogin: Boolean) {
//        val checkLogin = userModel.checkLogin(email, pw)
//
//        if (checkLogin) {
//            userModel.saveEmail(email)
//            userModel.saveAutoLogin(autoLogin)
//
//            val intent = Intent(context, MainActivity::class.java)
//            view.startIntent(intent)
//        } else {
//            view.showToast("일치하는 계정이 없습니다")
//        }
    }

    override fun getEmail(): String = "dummy"
//    override fun showEmail(): String? {
//        return userModel.getSavedEmail()
//    }
}
