package com.example.kotlinstudy.view.adapter

import com.example.kotlinstudy.data.room.Memo

interface AdapterContract {
    interface View{
        fun notifyAdapter()
    }

    interface Model{
        fun addItems(memos : ArrayList<Memo>)
        fun clearItem()
    }
}