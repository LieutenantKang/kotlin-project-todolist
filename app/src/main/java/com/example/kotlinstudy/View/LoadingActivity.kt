package com.example.kotlinstudy.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.kotlinstudy.Contract.LoadingContract
import com.example.kotlinstudy.Presenter.LoadingPresenter
import com.example.kotlinstudy.R

class LoadingActivity : AppCompatActivity(), LoadingContract.View {
    private var presenter: LoadingContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        presenter = LoadingPresenter(this@LoadingActivity, applicationContext, this)
        startLoading()
    }

    private fun startLoading(){
        var handler = Handler()
        handler.postDelayed(Runnable{
            run{
                var intent:Intent = if(presenter!!.getAutoLogin()!!){
                    Intent(this, MainActivity::class.java)
                }else{
                    Intent(this, LoginActivity::class.java)
                }
                startActivity(intent)
                finish()
            }
        }, 1000)
    }

    override fun setView() {
    }
}
