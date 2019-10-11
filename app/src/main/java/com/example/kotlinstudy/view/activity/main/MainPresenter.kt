package com.example.kotlinstudy.view.activity.main

import android.content.Context
import com.example.kotlinstudy.view.adapter.AdapterContract

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
    override fun start() {
        view.presenter = this
    }

//    override var model : MemoModel = MemoModel(context)

    private lateinit var adapterModel: AdapterContract.Model
    private lateinit var adapterView: AdapterContract.View

    override fun loadMemos(isClear: Boolean) {
//        model.getMemos().let{
//            if(isClear){
//                adapterModel.clearItem()
//            }
//            adapterModel.addItems(it)
//            adapterView.notifyAdapter()
//        }
    }
}
