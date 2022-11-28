package com.amrutha.amruthatestapplication.api

import com.amrutha.amruthatestapplication.model.CatDataItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("v1/breeds")
    fun getAllCats(): Call<List<CatDataItem>>

    companion object {
        private var apiService: ApiService? = null
        var BASE_URL = "https://api.thecatapi.com/"
        fun getInstance(): ApiService {
            if (apiService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                apiService = retrofit.create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}