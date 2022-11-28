package com.amrutha.amruthatestapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amrutha.amruthatestapplication.model.CatDataItem
import com.amrutha.amruthatestapplication.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val catList = MutableLiveData<List<CatDataItem>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllCats() {
        val response = repository.getAllCats()
        response.enqueue(object : Callback<List<CatDataItem>> {
            override fun onResponse(
                call: Call<List<CatDataItem>>,
                response: Response<List<CatDataItem>>
            ) {
                catList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<CatDataItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}