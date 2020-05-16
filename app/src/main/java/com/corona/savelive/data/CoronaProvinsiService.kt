package com.corona.savelive.data


import com.corona.savelive.DataprovinsiItem
import retrofit2.Call
import retrofit2.http.GET

interface CoronaProvinsiService {
    @GET("indonesia/provinsi")
    fun getProvinsi(): Call<List<DataprovinsiItem>>
}