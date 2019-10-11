package com.example.kotlinstudy.view.activity.login

import android.content.Intent
import com.example.kotlinstudy.R
import com.example.kotlinstudy.base.BaseActivity
import com.example.kotlinstudy.view.activity.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(),
        LoginContract.View {

    override val layoutRes: Int
        get() = R.layout.activity_login

    override fun initView() {
        presenter = LoginPresenter(this)
        presenter.start()

        login_email.setText(presenter.showEmail())
    }

    override fun onClickEvent() {
        super.onClickEvent()

        login_login_button.setOnClickListener {
            val email = login_email.text.toString()
            val pw = login_pw.text.toString()
            val autoLogin = login_auto.isChecked

            presenter.login(email, pw, autoLogin)
        }

        login_register_button.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    // region mvp
    override lateinit var presenter: LoginContract.Presenter

    override fun isViewActive(): Boolean = checkActive()
    // endregion
}
