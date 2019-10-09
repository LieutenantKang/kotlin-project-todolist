package com.example.kotlinstudy.Contract

import android.content.Context
import com.example.kotlinstudy.Model.MemoModel

interface MainContract {
    interface View {
        fun setView()
    }

    interface Presenter {
        var view: MainContract.View
        var model: MemoModel

        var adapterModel : AdapterContract.Model
        var adapterView : AdapterContract.View

        fun presenterView()

        fun loadMemos(context: Context, isClear: Boolean)
    }
}
