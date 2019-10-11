package com.example.kotlinstudy.view.activity.main

import android.content.Context
import com.example.kotlinstudy.base.BaseContract
import com.example.kotlinstudy.view.adapter.AdapterContract
import com.example.kotlinstudy.data.model.MemoModel

interface MainContract {
    interface View: BaseContract.BaseView<Presenter> {
        fun setRecyclerView()
    }

    interface Presenter: BaseContract.BasePresenter {
//        var model: MemoModel

//        var adapterModel : AdapterContract.Model
//        var adapterView : AdapterContract.View

//        fun presenterView()

        fun loadMemos(isClear: Boolean)
    }
}
