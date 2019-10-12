package com.example.kotlinstudy.data.model

import com.example.kotlinstudy.App.Companion.database
import com.example.kotlinstudy.data.room.User
import com.example.kotlinstudy.data.room.UserDao

class RegisterModel {
    private val userDao: UserDao by lazy { database.userDao }

    fun isPossibleEmail(email: String): Boolean = userDao.findUser(email).isNotEmpty()

    fun isConfirmPw(pw: String, pwCheck: String): Boolean = pw == pwCheck

    fun signUp(email: String, pw: String) {
        val user = User(email, pw)
        database.userDao.insert(user)
    }
}
