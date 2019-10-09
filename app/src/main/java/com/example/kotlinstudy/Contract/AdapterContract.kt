package com.example.kotlinstudy.Contract

import com.example.kotlinstudy.Room.Memo

interface AdapterContract {
    interface View{
        fun notifyAdapter()
    }

    interface Model{
        fun addItems(memos : ArrayList<Memo>)
        fun clearItem()
    }
}