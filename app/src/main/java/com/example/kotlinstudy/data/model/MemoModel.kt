package com.example.kotlinstudy.data.model

import android.content.Context
import com.example.kotlinstudy.data.room.Memo

class MemoModel(context: Context) {
    fun getMemos() :ArrayList<Memo>{
        val list = ArrayList<Memo>()
        // Memo를 DB에서 받아온다
        return list
    }
}