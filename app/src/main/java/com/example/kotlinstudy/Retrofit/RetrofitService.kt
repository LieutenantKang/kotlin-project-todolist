package com.example.kotlinstudy.Retrofit

import com.example.kotlinstudy.Retrofit.Request.LoginRequest
import com.example.kotlinstudy.Retrofit.Request.RegisterUserRequest
import com.example.kotlinstudy.Retrofit.Response.LoginResponse
import com.example.kotlinstudy.Retrofit.Response.RegisterUserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.*

interface RetrofitService {
    @Headers("Accept: application/json")
    @POST("/users/")
    fun registerUser(@Body user : RegisterUserRequest) : Call<RegisterUserResponse>

    @Headers("Accept: application/json")
    @POST("/api-token-auth/")
    fun login(@Body user : LoginRequest) : Call<LoginResponse>
}