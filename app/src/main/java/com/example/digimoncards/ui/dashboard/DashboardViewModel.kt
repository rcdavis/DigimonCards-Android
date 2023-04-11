package com.example.digimoncards.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.digimoncards.api.DigimonCard
import com.example.digimoncards.api.util.RetrofitUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DashboardViewModel : ViewModel() {
    private val digimonCardApi = RetrofitUtils.createDigimonCardApi()

    suspend fun getAgumonCards(): List<DigimonCard> {
        return withContext(Dispatchers.IO) {
            return@withContext digimonCardApi.getCards(
                "Agumon",
                "Reveal 5 cards",
                "red",
                "digimon",
                "Vaccine",
                "BT1-010",
                "BT01-03: Release Special Booster Ver.1.0",
                "name",
                "desc",
                "Digimon Card Game"
            ).map { DigimonCard.from(it) }
        }
    }
}