package com.example.digimoncards.ui.dashboard

import androidx.lifecycle.ViewModel
import com.example.digimoncards.api.DigimonCard
import com.example.digimoncards.api.DigimonCardRepository

class DashboardViewModel(
    private val digimonCardRepository: DigimonCardRepository
) : ViewModel() {
    suspend fun getAgumonCard(): DigimonCard? {
        return digimonCardRepository.getCard("BT1-010")
    }
}