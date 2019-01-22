package com.example.root.wisatakotlinapi.retrofit

import com.example.root.wisatakotlinapi.model.Resultgetdata
import retrofit2.Call
import retrofit2.http.GET

interface getdataService {

    @GET("?action=findAll")
    fun getdata() : Call<Resultgetdata>

}
