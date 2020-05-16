package com.corona.savelive.data

import com.corona.savelive.DataInterationalItem
import retrofit2.Call
import retrofit2.http.GET

interface CoronaInternationalService {
    @GET(".")
    fun getProvinsi(): Call<List<DataInterationalItem>>

}