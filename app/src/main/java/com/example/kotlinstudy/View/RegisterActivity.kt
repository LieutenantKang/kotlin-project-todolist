package com.example.kotlinstudy.View

import android.os.Bundle
import android.view.View
import com.example.kotlinstudy.Contract.RegisterContract
import com.example.kotlinstudy.Presenter.RegisterPresenter
import com.example.kotlinstudy.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(), RegisterContract.View, View.OnClickListener {
    private var presenter: RegisterContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter = RegisterPresenter(this@RegisterActivity, applicationContext, this)
        presenter!!.presenterView()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.register_register_button -> {
                val email = register_email.text.toString()
                val pw = register_pw.text.toString()
                val pwCheck = register_pwCheck.text.toString()
                presenter!!.signUp(email, pw, pwCheck)
            }
        }
    }

    override fun setView() {
        register_register_button!!.setOnClickListener(this)
    }
}
