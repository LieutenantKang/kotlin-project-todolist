package com.example.kotlinstudy.view.activity.loading

import com.example.kotlinstudy.data.model.UserModel

class LoadingPresenter(val view: LoadingContract.View) : LoadingContract.Presenter {

    override fun start() {
        view.presenter = this
    }

//    private val userModel: UserModel = UserModel(context)

    override fun getAutoLogin(): Boolean = true
//        return userModel.getAutoLogin()
//    }
}