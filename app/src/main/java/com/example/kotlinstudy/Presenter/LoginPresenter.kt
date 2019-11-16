package com.example.kotlinstudy.Presenter

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.kotlinstudy.Contract.LoginContract
import com.example.kotlinstudy.Model.UserModel
import com.example.kotlinstudy.View.MainActivity

class LoginPresenter(private val view: LoginContract.View, private val context: Context, private val activity: Activity) : LoginContract.Presenter, LoginContract.Model.OnLoginFinishedListener {

    private val userModel: UserModel = UserModel(context)

    override fun presenterView() {
        view.setView()
    }

    override fun login(email: String, pw: String, autoLogin: Boolean) {
        userModel.login(this, email, pw, autoLogin)
    }

    override fun onFinished(token: String, autoLogin: Boolean) {
        if(autoLogin){
            userModel.saveAutoLogin(autoLogin)
        }
        val intent = Intent(context, MainActivity::class.java)
        view.startIntent(intent)
    }

    override fun onFailure(t: Throwable) {
        view.showToast("일치하는 계정이 없습니다")
    }


    override fun showEmail(): String? {
        return userModel.getSavedEmail()
    }
}
