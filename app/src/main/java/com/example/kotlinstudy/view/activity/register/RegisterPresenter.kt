package com.example.kotlinstudy.view.activity.register

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.kotlinstudy.data.model.UserModel
import com.example.kotlinstudy.view.activity.login.LoginActivity

class RegisterPresenter(private val view: RegisterContract.View) : RegisterContract.Presenter {
    override fun start() {
        view.presenter = this
    }

//    private val userModel: UserModel = UserModel(context)

//    override fun presenterView() {
//        view.setView()
//    }

    override fun signUp(email: String, pw: String, pwCheck: String) {
//        when (userModel.signUp(email, pw, pwCheck)) {
//            "Success" -> {
//                val intent = Intent(context, LoginActivity::class.java)
//                view.startIntent(intent)
//            }
//            "NotChecked" -> view.showToast("비밀번호와 비밀번호 확인이 일치하지 않습니다")
//            else -> view.showToast("동일한 이메일의 계정이 존재합니다")
//        }
    }
}
