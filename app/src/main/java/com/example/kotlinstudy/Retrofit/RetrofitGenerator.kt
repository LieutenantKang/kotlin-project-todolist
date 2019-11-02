package com.example.kotlinstudy.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitGenerator {
    private val retrofit = Retrofit.Builder()
                    .baseUrl("https://prographytodolist.azurewebsites.net")
                    .addConverterFactory(GsonConverterFactory.create()).build()

    fun create(): RetrofitService = retrofit.create(RetrofitService::class.java)
}