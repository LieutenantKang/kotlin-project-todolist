package com.example.kotlinstudy.View

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

import com.example.kotlinstudy.Interface.RegisterInterface
import com.example.kotlinstudy.Presenter.RegisterPresenter
import com.example.kotlinstudy.R

class RegisterActivity : AppCompatActivity(), RegisterInterface.View, View.OnClickListener {
    private var presenter: RegisterInterface.Presenter? = null

    private var registerBtn: TextView? = null

    private var emailEdit: EditText? = null
    private var pwEdit: EditText? = null
    private var pwCheckEdit: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter = RegisterPresenter(this@RegisterActivity, applicationContext, this)
        presenter!!.presenterView()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.register_register_button -> {
                val email = emailEdit!!.text.toString()
                val pw = pwEdit!!.text.toString()
                val pwCheck = pwCheckEdit!!.text.toString()
                presenter!!.signUp(email, pw, pwCheck)
            }
        }
    }

    override fun setView() {
        registerBtn = findViewById<View>(R.id.register_register_button) as TextView
        emailEdit = findViewById<View>(R.id.register_email) as EditText
        pwEdit = findViewById<View>(R.id.register_pw) as EditText
        pwCheckEdit = findViewById<View>(R.id.register_pwCheck) as EditText

        registerBtn!!.setOnClickListener(this)
    }
}
