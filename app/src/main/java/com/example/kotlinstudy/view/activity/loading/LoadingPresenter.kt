package com.example.kotlinstudy.view.activity.loading

class LoadingPresenter(val view: LoadingContract.View) : LoadingContract.Presenter {

    override fun start() {
        view.presenter = this
    }

//    private val userModel: RegisterModel = RegisterModel(context)

    override fun getAutoLogin(): Boolean = true
//        return userModel.getAutoLogin()
//    }
}