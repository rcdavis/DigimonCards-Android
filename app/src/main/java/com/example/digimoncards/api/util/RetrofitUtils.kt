package com.example.digimoncards.api.util

import com.example.digimoncards.BuildConfig
import com.example.digimoncards.api.DigimonCardApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtils {
    fun createDigimonCardApi(): DigimonCardApi {
        return createApi(DigimonCardApi::class.java, BuildConfig.DIGIMON_CARD_API_URL)
    }

    private fun <T> createApi(tClass: Class<T>, baseUrl: String): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            //.addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(tClass)
    }
}