package com.example.kotlinstudy.View

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    open fun setView() {
    }

    open fun showToast(title: String) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
    }

    open fun startIntent(intent: Intent) {
        startActivity(intent)
        finish()
    }
}