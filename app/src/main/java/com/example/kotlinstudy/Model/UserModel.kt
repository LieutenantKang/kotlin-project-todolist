package com.example.kotlinstudy.Model

import android.content.Context

import com.example.kotlinstudy.Room.User
import com.example.kotlinstudy.Room.UserDao
import com.example.kotlinstudy.Room.UserDatabase

import java.util.ArrayList

class UserModel(private val context: Context) {
    private var database: UserDatabase = UserDatabase.getInstance(context)
    private var userDao: UserDao

    init {
        userDao = database.userDao
    }

    fun checkLogin(email: String, pw: String): Boolean {
        val userList = ArrayList<User>()
        val loginThread = Thread { userList.addAll(userDao.userLogin(email,pw)) }
        loginThread.start()

        try {
            loginThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return if (userList.size == 0) {
            false
        } else userList[0].email == email
    }

    fun signUp(email: String, pw: String, pwCheck: String): String {
        val userList = ArrayList<User>()
        val signUpThread = Thread { userList.addAll(userDao.findUser(email)) }
        signUpThread.start()

        try {
            signUpThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        if (userList.size != 0) {
            return "Already" // 내부 DB Room 통해 데이터 존재 여부 확인
        }

        if (pw != pwCheck) {
            return "NotChecked"
        }

        val user = User(email, pw)
        Thread { database.userDao.insert(user) }.start()
        return "Success"
    }
}
