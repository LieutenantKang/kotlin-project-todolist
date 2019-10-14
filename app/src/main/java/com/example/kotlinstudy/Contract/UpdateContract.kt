package com.example.kotlinstudy.Contract

import com.example.kotlinstudy.Room.Memo

interface UpdateContract {
    interface View{
        fun setView()
    }

    interface Presenter{
        fun presenterView()
        fun updateMemo(id: Int, memo: Memo)
        fun getMemo(id: Int) : Memo
    }
}