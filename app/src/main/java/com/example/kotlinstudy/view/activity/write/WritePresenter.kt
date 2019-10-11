package com.example.kotlinstudy.view.activity.write

import android.app.Activity
import android.content.Context
import com.example.kotlinstudy.data.model.MemoModel

class WritePresenter(private val view: WriteContract.View) : WriteContract.Presenter {
    override fun start() {
        view.presenter = this
    }
//    private val memoModel : MemoModel = MemoModel(context)

//    override fun presenterView(){
//        view.setView()
//    }
}