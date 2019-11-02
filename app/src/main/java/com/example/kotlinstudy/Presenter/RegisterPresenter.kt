package com.example.kotlinstudy.Presenter

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.kotlinstudy.Contract.RegisterContract
import com.example.kotlinstudy.Model.UserModel
import com.example.kotlinstudy.View.LoginActivity

class RegisterPresenter(private val view: RegisterContract.View, private val context: Context, private val activity: Activity) : RegisterContract.Presenter {
    private val userModel: UserModel = UserModel(context)

    override fun presenterView() {
        view.setView()
    }

    override fun signUp(email: String, pw: String, pwCheck: String) {
        when (userModel.signUp(email, pw, pwCheck)) {
            "Success" -> {
                val intent = Intent(context, LoginActivity::class.java)
                view.startIntent(intent)
            }
            else -> view.showToast("가입에 실패했습니다")
        }
    }
}
