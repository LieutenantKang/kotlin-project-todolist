package com.example.kotlinstudy.Presenter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast

import com.example.kotlinstudy.Interface.LoginInterface
import com.example.kotlinstudy.Model.UserModel
import com.example.kotlinstudy.View.MainActivity

import android.content.Intent.FLAG_ACTIVITY_NEW_TASK

class LoginPresenter(private val view: LoginInterface.View, private val context: Context, private val activity: Activity) : LoginInterface.Presenter {
    private val userModel: UserModel = UserModel(context)

    override fun presenterView() {
        view.setView()
    }

    override fun Login(email: String, pw: String) {
        val checkLogin = userModel.checkLogin(email, pw)

        if (checkLogin) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent.addFlags(FLAG_ACTIVITY_NEW_TASK))
            activity.finish()
        } else {
            view.showToast("일치하는 계정이 없습니다")
        }
    }
}
