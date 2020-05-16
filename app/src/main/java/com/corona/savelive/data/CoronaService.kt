package com.corona.savelive.data

import com.corona.savelive.CoronaIndonesiaItem
import retrofit2.Call
import retrofit2.http.GET

interface CoronaService {

    @GET("indonesia")
    fun getProvinsi():Call<List<CoronaIndonesiaItem>>
}