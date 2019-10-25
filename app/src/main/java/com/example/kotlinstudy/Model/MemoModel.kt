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

    fun updateMemo(id: Int, memo: Memo){
        val deleteMemoThread = Thread { memoDao.deleteMemo(id) }
        deleteMemoThread.start()

        try{
            deleteMemoThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val insertMemoThread = Thread { memoDao.insert(memo) }
        insertMemoThread.start()

        try{
            insertMemoThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    fun getMemo(id: Int) : Memo{
        var memo = Memo()

        val getMemoThread = Thread { memo = memoDao.getMemo(id)}
        getMemoThread.start()

        try{
            getMemoThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return memo
    }

    fun getMemos(): ArrayList<Memo> {
        val memoList = ArrayList<Memo>()

        val getMemosThread = Thread { memoList.addAll(memoDao.getMemos()) }
        getMemosThread.start()

        try {
            getMemosThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return memoList
    }

    fun insertMemo(memo: Memo) {
        Thread { database.memoDao.insert(memo) }.start()
    }

    fun deleteMemo(id : Int){
        Thread {database.memoDao.deleteMemo(id)}.start()
    }
}