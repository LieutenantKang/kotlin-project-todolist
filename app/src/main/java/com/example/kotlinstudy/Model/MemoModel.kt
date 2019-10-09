package com.example.kotlinstudy.Model

import android.content.Context
import com.example.kotlinstudy.Room.Memo

class MemoModel(context: Context) {
    fun getMemos() :ArrayList<Memo>{
        val list = ArrayList<Memo>()
        // Memo를 DB에서 받아온다
        return list
    }
}