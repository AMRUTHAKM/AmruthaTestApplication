package com.amrutha.amruthatestapplication.repository

import com.amrutha.amruthatestapplication.api.ApiService

class MainRepository constructor (private val apiService: ApiService) {
    fun getAllCats() = apiService.getAllCats()
}