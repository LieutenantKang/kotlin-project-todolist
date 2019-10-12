package com.example.kotlinstudy.data.model

import com.example.kotlinstudy.App
import com.example.kotlinstudy.common.Const
import com.example.kotlinstudy.data.room.User
import com.example.kotlinstudy.data.room.UserDao
import com.example.kotlinstudy.util.setPrefBoolean
import java.util.ArrayList

class LoginModel {
    private val userDao: UserDao by lazy { App.database.userDao }

    fun checkLogin(email: String, pw: String): Boolean {
        val userList = ArrayList<User>()
        val loginThread = Thread { userList.addAll(userDao.userLogin(email, pw)) }
        loginThread.start()

        try {
            loginThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return when {
            userList.size == 0 -> false
            userList[0].email == email -> {
                true
            }
            else -> false
        }
    }

    fun setAutoLogin(isAutoLogin: Boolean) {
        setPrefBoolean(Const.PREF.IS_AUTO_LOGIN , isAutoLogin)
    }
}