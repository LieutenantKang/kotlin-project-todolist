package com.example.kotlinstudy.view.activity.loading

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.kotlinstudy.R
import com.example.kotlinstudy.base.BaseActivity
import com.example.kotlinstudy.view.activity.login.LoginActivity
import com.example.kotlinstudy.view.activity.main.MainActivity

class LoadingActivity : BaseActivity(), LoadingContract.View {

    override val layoutRes: Int
        get() = R.layout.activity_loading

    override fun initView() {
        presenter = LoadingPresenter(this)
        presenter.start()
        startLoading()
    }

    private fun startLoading() {
        Handler().postDelayed({
            startActivity(Intent(this,
                    if (presenter.getAutoLogin()) MainActivity::class.java
                    else LoginActivity::class.java))
        }, 1000)
    }

    // region mvp
    override lateinit var presenter: LoadingContract.Presenter

    override fun isViewActive(): Boolean = checkActive()
    // endregion
}
