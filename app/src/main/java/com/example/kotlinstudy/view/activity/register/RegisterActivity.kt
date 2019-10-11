package com.example.kotlinstudy.view.activity.register

import android.content.Intent
import com.example.kotlinstudy.R
import com.example.kotlinstudy.base.BaseActivity
import com.example.kotlinstudy.util.showToast
import com.example.kotlinstudy.view.activity.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(), RegisterContract.View {

    override val layoutRes: Int
        get() = R.layout.activity_register

    override fun initView() {
        presenter = RegisterPresenter(this)
        presenter.start()
    }

    override fun onClickEvent() {
        super.onClickEvent()

        register_register_button.setOnClickListener {
            val email = register_email.text.toString()
            val pw = register_pw.text.toString()
            val pwCheck = register_pwCheck.text.toString()
            presenter.signUp(email, pw, pwCheck)
        }
    }

    // region mvp
    override lateinit var presenter: RegisterContract.Presenter

    override fun isViewActive(): Boolean = checkActive()

    override fun showToastMessage(msg: String) { showToast(msg) }

    override fun getResult(result: String) {
        when (result) {
            "Success" -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            "NotChecked" -> showToast("비밀번호와 비밀번호 확인이 일치하지 않습니다")
            else -> showToast("동일한 이메일의 계정이 존재합니다")
        }
    }
    // endregion
}
