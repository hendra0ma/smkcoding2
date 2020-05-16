package com.corona.savelive.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun httpClient(): OkHttpClient {
    val logInceptor = HttpLoggingInterceptor()
    logInceptor.level = HttpLoggingInterceptor.Level.BODY

    val reload = OkHttpClient.Builder()
    reload.readTimeout(15,TimeUnit.SECONDS)
    reload.connectTimeout(15,TimeUnit.SECONDS)
    reload.addInterceptor(logInceptor)
    return reload.build()
}
inline fun <reified T>apiRequest(okHttpClient: OkHttpClient): T {

    val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.kawalcorona.com")
                    .client(okHttpClient)
                    .addConverterFactory(
                        GsonConverterFactory.create(
                            GsonBuilder().create()
                        )
                    ).build()

    return retrofit.create(T::class.java)

}