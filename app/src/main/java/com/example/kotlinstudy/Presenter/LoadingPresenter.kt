package com.example.kotlinstudy.Presenter

import android.app.Activity
import android.content.Context
import com.example.kotlinstudy.Contract.LoadingContract
import com.example.kotlinstudy.Model.UserModel

class LoadingPresenter(private val view: LoadingContract.View, private val context: Context, private val activity: Activity) : LoadingContract.Presenter {
    private val userModel: UserModel = UserModel(context)

    override fun getAutoLogin(): Boolean? {
        return userModel.getAutoLogin()
    }
}