package com.example.digimoncards.api

import com.example.digimoncards.api.dto.DigimonCardDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DigimonCardApi {
    @GET("search.php")
    fun getCards(
        @Query("n") name: String? = null,
        @Query("desc") description: String? = null,
        @Query("color") color: String? = null,
        @Query("type") type: String? = null,
        @Query("attribute") attribute: String? = null,
        @Query("card") cardNumber: String? = null,
        @Query("pack") packName: String? = null,
        @Query("sort") sort: String? = null,
        @Query("sortdirection") sortDirection: String? = null,
        @Query("series") seriesName: String? = null
    ): Call<List<DigimonCardDto>>

    @GET("getAllCards.php")
    fun getAllCards(
        @Query("sort") sort: String? = null,
        @Query("series") seriesName: String? = null,
        @Query("sortdirection") sortDirection: String? = null
    ): Call<List<DigimonCardDto>>
}