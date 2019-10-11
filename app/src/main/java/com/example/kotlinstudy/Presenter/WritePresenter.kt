package com.example.kotlinstudy.Presenter

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.kotlinstudy.Adapter.MemoAdapter
import com.example.kotlinstudy.Contract.AdapterContract
import com.example.kotlinstudy.Contract.WriteContract
import com.example.kotlinstudy.Model.MemoModel
import com.example.kotlinstudy.Room.Memo
import com.example.kotlinstudy.View.MainActivity

class WritePresenter(private val view: WriteContract.View, private val context : Context, private val activity : Activity) : WriteContract.Presenter {

    private val memoModel : MemoModel = MemoModel(context)

    override fun presenterView(){
        view.setView()
    }

    override fun insertMemo(memo: Memo) {
        memoModel.insertMemo(memo)
    }
}