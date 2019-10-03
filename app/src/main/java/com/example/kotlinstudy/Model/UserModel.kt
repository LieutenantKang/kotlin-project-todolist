package com.example.kotlinstudy.Model

import android.content.Context

import com.example.kotlinstudy.Room.User
import com.example.kotlinstudy.Room.UserDao
import com.example.kotlinstudy.Room.UserDatabase
import android.content.SharedPreferences

import java.util.ArrayList

class UserModel(context: Context) {
    private var database: UserDatabase = UserDatabase.getInstance(context)
    private var userDao: UserDao

    private var sharedPreferences : SharedPreferences? = null
    private var editor : SharedPreferences.Editor? = null

    init {
        userDao = database.userDao
        sharedPreferences = context.getSharedPreferences("pref", 0)
    }

    fun getAutoLogin():Boolean{
        return sharedPreferences?.getBoolean("autoLogin",false) ?: false
    }

    fun saveAutoLogin(autoLogin:Boolean){
        editor= sharedPreferences?.edit()
        editor?.putBoolean("autoLogin",autoLogin)
        editor?.commit()
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

        return when {
            userList.size==0 -> false
            userList[0].email==email -> {
                true
            }
            else -> false
        }
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

    fun saveEmail(email: String){
        editor= sharedPreferences?.edit()
        editor?.putString("userEmail",email)
        editor?.commit()
    }

    fun getSavedEmail(): String? {
        return sharedPreferences?.getString("userEmail","")
    }
}
