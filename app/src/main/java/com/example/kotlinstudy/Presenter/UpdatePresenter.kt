package com.example.kotlinstudy.Presenter

import android.app.Activity
import android.content.Context
import com.example.kotlinstudy.Contract.UpdateContract
import com.example.kotlinstudy.Model.MemoModel
import com.example.kotlinstudy.Room.Memo

class UpdatePresenter(private val view:UpdateContract.View, private val context : Context, private val activity: Activity) : UpdateContract.Presenter {

    private val memoModel : MemoModel = MemoModel(context)

    override fun presenterView() {
        view.setView()
    }

    override fun getMemo(id: Int): Memo {
        return memoModel.getMemo(id)
    }

    override fun updateMemo(id: Int, memo: Memo) {
        memoModel.updateMemo(id, memo)
    }
}