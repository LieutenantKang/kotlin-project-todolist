package com.example.kotlinstudy.data.model

import com.example.kotlinstudy.App
import com.example.kotlinstudy.App.Companion.database
import com.example.kotlinstudy.common.Const
import com.example.kotlinstudy.data.room.User
import com.example.kotlinstudy.data.room.UserDao
import com.example.kotlinstudy.util.setPrefBoolean
import java.util.ArrayList

class LoginModel {
    fun isCheckLogin(email: String, pw: String): Boolean {
        val userList = database.userDao.loginUser(email, pw)

        return when {
            userList.isEmpty() -> false
            userList[0].email == email -> true
            else -> false
        }
    }

    fun setAutoLogin(isAutoLogin: Boolean) {
        setPrefBoolean(Const.PREF.IS_AUTO_LOGIN , isAutoLogin)
    }
}