package com.example.kotlinstudy.Model

import android.content.Context
import com.example.kotlinstudy.Room.Memo
import com.example.kotlinstudy.Room.MemoDao
import com.example.kotlinstudy.Room.MemoDatabase

class MemoModel(context: Context) {
    private var database: MemoDatabase = MemoDatabase.getInstance(context)
    private var memoDao: MemoDao

    init {
        memoDao = database.memoDao
    }

    fun getMemos(): ArrayList<Memo> {
        val memoList = ArrayList<Memo>()

        val insertMemoThread = Thread { memoList.addAll(memoDao.getMemos()) }
        insertMemoThread.start()

        try {
            insertMemoThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return memoList
    }

    fun insertMemo(memo: Memo) {
        Thread { database.memoDao.insert(memo) }.start()
    }
}