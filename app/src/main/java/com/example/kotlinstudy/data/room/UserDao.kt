package com.example.kotlinstudy.data.room

import androidx.room.*
import androidx.room.Update



@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Update
    fun updateUser(vararg user: User)

    @Delete
    fun deleteAllUser()

    @Delete
    fun deleteUser(vararg user: User)

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM user WHERE email = (:email)")
    fun findUser(email: String): List<User>

    @Query("SELECT * FROM user WHERE email = (:email) AND password = (:pw)")
    fun loginUser(email: String, pw: String): List<User>
}
