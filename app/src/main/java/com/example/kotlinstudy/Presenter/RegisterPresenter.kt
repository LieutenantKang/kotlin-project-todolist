package com.example.kotlinstudy.Presenter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast

import com.example.kotlinstudy.Interface.RegisterInterface
import com.example.kotlinstudy.Model.UserModel
import com.example.kotlinstudy.View.LoginActivity

import android.content.Intent.FLAG_ACTIVITY_NEW_TASK

class RegisterPresenter(private val view: RegisterInterface.View, private val context: Context, private val activity: Activity) : RegisterInterface.Presenter {
    private val userModel: UserModel = UserModel(context)

    override fun presenterView() {
        view.setView()
    }

    override fun signUp(email: String, pw: String, pwCheck: String) {
        when (userModel.signUp(email, pw, pwCheck)) {
            "Success" -> {
                // 자동 로그인 처리 필요

                val intent = Intent(context, LoginActivity::class.java)
                context.startActivity(intent.addFlags(FLAG_ACTIVITY_NEW_TASK))
                activity.finish()
                // 테스트를 위해 LoginActivity 로 이동. 추후 MainActivity 로 변경 예정
            }
            "NotChecked" -> view.showToast("비밀번호와 비밀번호 확인이 일치하지 않습니다")
            else -> view.showToast("동일한 이메일의 계정이 존재합니다")
        }
    }
}
