package com.example.kotlinstudy.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinstudy.util.changeStatusBar

abstract class BaseActivity : AppCompatActivity() {

    abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)

        title = ""
        changeStatusBar(android.R.color.black)

        initView()
        onClickEvent()
    }

    abstract fun initView()
    open fun onClickEvent() {}

    fun checkActive(): Boolean = !isFinishing
}