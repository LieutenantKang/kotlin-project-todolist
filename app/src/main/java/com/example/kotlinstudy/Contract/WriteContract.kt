package com.example.kotlinstudy.Contract

import android.content.Intent
import com.example.kotlinstudy.Room.Memo

interface WriteContract {
    interface View{
        fun setView()
        fun startIntent(intent: Intent)
    }

    interface Presenter {
        fun presenterView()
        fun insertMemo(memo: Memo)
    }
}