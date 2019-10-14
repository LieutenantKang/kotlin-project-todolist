package com.example.kotlinstudy.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MemoDao {
    @Query("DELETE FROM memo WHERE id = (:id)")
    fun deleteMemo(id: Int)

    @Query("SELECT * FROM memo WHERE id = (:id)")
    fun getMemo(id: Int) : Memo

    @Query("SELECT * FROM memo")
    fun getMemos(): List<Memo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(memo: Memo)
}