package com.example.root.wisatakotlinapi.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.http.GET


class ConfigNetwork {

    val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    var retrofit = Retrofit.Builder()
        .baseUrl("http://udacoding.com/api/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service = retrofit.create<getdataService>(getdataService::class.java!!)
}

