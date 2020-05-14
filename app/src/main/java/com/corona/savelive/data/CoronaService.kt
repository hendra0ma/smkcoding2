package com.corona.savelive.data

import KawalCoronaItem
import retrofit2.Call
import retrofit2.http.GET

interface CoronaService {

    @GET("provinsi")
    fun getProvinsi():Call<List<KawalCoronaItem>>
}