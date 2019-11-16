package com.example.kotlinstudy.Model

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.kotlinstudy.Contract.LoginContract
import com.example.kotlinstudy.Retrofit.Request.RegisterUserRequest
import com.example.kotlinstudy.Retrofit.Response.RegisterUserResponse
import com.example.kotlinstudy.Retrofit.RetrofitGenerator
import com.example.kotlinstudy.Room.User
import com.example.kotlinstudy.Room.UserDao
import com.example.kotlinstudy.Room.UserDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import com.example.kotlinstudy.Contract.RegisterContract
import com.example.kotlinstudy.Retrofit.Request.LoginRequest
import com.example.kotlinstudy.Retrofit.Response.LoginResponse


class UserModel(context: Context) : RegisterContract.Model, LoginContract.Model{

    private var database: UserDatabase = UserDatabase.getInstance(context)
    private var userDao: UserDao

    private var sharedPreferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    init {
        userDao = database.userDao
        sharedPreferences = context.getSharedPreferences("pref", 0)
    }

    fun getAutoLogin(): Boolean {
        return sharedPreferences?.getBoolean("autoLogin", false) ?: false
    }

    fun saveAutoLogin(autoLogin: Boolean) {
        editor = sharedPreferences?.edit()
        editor?.putBoolean("autoLogin", autoLogin)
        editor?.commit()
    }

    override fun login(onLoginFinishedListener: LoginContract.Model.OnLoginFinishedListener, email: String, pw: String, autoLogin: Boolean) {
        val loginRequest = LoginRequest(email, pw)
        val call = RetrofitGenerator.create().login(loginRequest)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                onLoginFinishedListener.onFinished(response.body()?.token.toString(), autoLogin)
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                onLoginFinishedListener.onFailure(t)
            }
        })
    }

    override fun signUp(onFinishedListener: RegisterContract.Model.OnFinishedListener, email: String, pw: String, pwCheck: String) {
        val userRequest = RegisterUserRequest(email, pw, pwCheck)
        val call = RetrofitGenerator.create().registerUser(userRequest)


        call.enqueue(object : Callback<RegisterUserResponse> {
            override fun onResponse(call: Call<RegisterUserResponse>, response: Response<RegisterUserResponse>) {
                Log.d("success", response.body()?.username.toString())
                onFinishedListener.onFinished(1)
            }
            override fun onFailure(call: Call<RegisterUserResponse>, t: Throwable) {
                Log.d("fail", "failed")
                onFinishedListener.onFailure(t)
            }
        })
    }

    fun saveEmail(email: String) {
        editor = sharedPreferences?.edit()
        editor?.putString("userEmail", email)
        editor?.commit()
    }

    fun getSavedEmail(): String? {
        return sharedPreferences?.getString("userEmail", "")
    }
}
