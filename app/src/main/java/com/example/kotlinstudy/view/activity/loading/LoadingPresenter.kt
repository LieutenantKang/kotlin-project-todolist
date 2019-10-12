package com.example.kotlinstudy.view.activity.loading

import com.example.kotlinstudy.data.model.LoadingModel

class LoadingPresenter(val view: LoadingContract.View) : LoadingContract.Presenter {

    private val model: LoadingModel by lazy { LoadingModel() }

    override fun start() {
        view.presenter = this
    }

    override fun getAutoLogin(): Boolean = model.getIsAutoLogin()
}