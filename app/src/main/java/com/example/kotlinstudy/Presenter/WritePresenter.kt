package com.example.kotlinstudy.Presenter

import android.app.Activity
import android.content.Context
import com.example.kotlinstudy.Contract.WriteContract
import com.example.kotlinstudy.Model.MemoModel

class WritePresenter(private val view: WriteContract.View, private val context : Context, private val activity : Activity) : WriteContract.Presenter {
    private val memoModel : MemoModel = MemoModel(context)

    override fun presenterView(){
        view.setView()
    }
}