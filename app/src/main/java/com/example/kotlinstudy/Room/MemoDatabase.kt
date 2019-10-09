package com.example.kotlinstudy.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Memo::class], version = 1, exportSchema = false)
abstract class MemoDatabase : RoomDatabase() {
    abstract val memoDao: MemoDao

    companion object {
        private var instance: MemoDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MemoDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext, MemoDatabase::class.java, "memo.db")
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return instance as MemoDatabase
        }
    }
}