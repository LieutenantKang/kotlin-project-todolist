package com.example.kotlinstudy.data.model

import com.example.kotlinstudy.App.Companion.database
import com.example.kotlinstudy.data.room.User

class RegisterModel {
    fun isPossibleEmail(email: String): Boolean = database.userDao.findUser(email).isNotEmpty()

    fun isConfirmPw(pw: String, pwCheck: String): Boolean = pw == pwCheck

    fun signUp(email: String, pw: String) {
        val user = User(0, email, pw, false)
        database.userDao.insert(user)
    }
}
