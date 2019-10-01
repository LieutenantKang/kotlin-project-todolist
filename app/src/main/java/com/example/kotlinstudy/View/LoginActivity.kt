package com.example.kotlinstudy.View

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

import com.example.kotlinstudy.Interface.LoginInterface
import com.example.kotlinstudy.Presenter.LoginPresenter
import com.example.kotlinstudy.R

class LoginActivity : AppCompatActivity(), LoginInterface.View, View.OnClickListener {
    private var presenter: LoginInterface.Presenter? = null

    private var loginBtn: TextView? = null
    private var registerBtn: TextView? = null

    private var emailEdit: EditText? = null
    private var pwEdit: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this@LoginActivity, applicationContext, this)
        presenter!!.presenterView()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.login_login_button -> {
                val email = emailEdit!!.text.toString()
                val pw = pwEdit!!.text.toString()
                presenter!!.Login(email, pw)
            }
            R.id.login_register_button -> {
                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun setView() {
        loginBtn = findViewById<View>(R.id.login_login_button) as TextView
        registerBtn = findViewById<View>(R.id.login_register_button) as TextView
        emailEdit = findViewById<View>(R.id.login_email) as EditText
        pwEdit = findViewById<View>(R.id.login_pw) as EditText

        loginBtn!!.setOnClickListener(this)
        registerBtn!!.setOnClickListener(this)
    }
}
