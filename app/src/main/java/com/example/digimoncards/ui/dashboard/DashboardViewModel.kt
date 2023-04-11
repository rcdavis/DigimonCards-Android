package com.example.digimoncards.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digimoncards.api.DigimonCard
import com.example.digimoncards.api.util.RetrofitUtils
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }

    val text: LiveData<String> = _text

    private val digimonCardApi = RetrofitUtils.createDigimonCardApi()

    fun printCards() {
        viewModelScope.launch {
            try {
                val cards = digimonCardApi.getCards(
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

                Log.d("DigimonDebug", cards.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}