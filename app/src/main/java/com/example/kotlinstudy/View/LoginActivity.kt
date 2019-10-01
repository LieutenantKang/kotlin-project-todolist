package com.example.kotlinstudy.View

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText

import com.example.kotlinstudy.Interface.LoginInterface
import com.example.kotlinstudy.Presenter.LoginPresenter
import com.example.kotlinstudy.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginInterface.View, View.OnClickListener {
    private var presenter: LoginInterface.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this@LoginActivity, applicationContext, this)
        presenter!!.presenterView()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.login_login_button -> {
                val email = login_email.text.toString()
                val pw = login_pw.text.toString()
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
        login_login_button!!.setOnClickListener(this)
        login_register_button!!.setOnClickListener(this)
    }

    override fun showToast(title: String) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
    }
}
