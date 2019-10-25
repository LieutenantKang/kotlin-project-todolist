package com.example.kotlinstudy.Presenter

import android.content.Context
import com.example.kotlinstudy.Contract.AdapterContract

import com.example.kotlinstudy.Contract.MainContract
import com.example.kotlinstudy.Model.MemoModel

class MainPresenter(private val mainView: MainContract.View, private val context: Context) : MainContract.Presenter {
    override lateinit var view : MainContract.View
    override var model : MemoModel = MemoModel(context)

    override lateinit var adapterModel: AdapterContract.Model
    override lateinit var adapterView: AdapterContract.View

    override fun presenterView() {
        view.setView()
    }

    override fun loadMemos(context: Context, isClear: Boolean) {
        model.getMemos().let{
            if(isClear){
                adapterModel.clearItem()
            }
            adapterModel.addItems(it)
            adapterView.notifyAdapter()
        }
    }

    override fun removeItem(position: Int) {
        model.deleteMemo(adapterModel.getMemoId(position))
        adapterModel.removeItem(position)
    }
}
