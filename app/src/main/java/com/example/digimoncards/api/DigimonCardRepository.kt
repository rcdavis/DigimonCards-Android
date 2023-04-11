package com.example.digimoncards.api

import com.example.digimoncards.api.dto.DigimonCardDto
import com.example.digimoncards.api.util.RetrofitUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.Query

class DigimonCardRepository {
    private val digimonCardApi = RetrofitUtils.createDigimonCardApi()

    private val cardDB = mutableMapOf<String, DigimonCard>()

    suspend fun getCards(
        name: String? = null,
        description: String? = null,
        color: CardColor? = null,
        type: CardType? = null,
        attribute: String? = null,
        cardNumber: String? = null,
        packName: String? = null,
        sort: String? = null,
        sortDirection: String? = null,
        seriesName: String? = null
    ): List<DigimonCard> {
        return withContext(Dispatchers.IO) {
            val cards = digimonCardApi.getCards(
                name,
                description,
                color?.text,
                type?.text,
                attribute,
                cardNumber,
                packName,
                sort,
                sortDirection,
                seriesName
            ).map { DigimonCard.from(it) }

            cards.forEach {
                cardDB[it.number] = it
            }

            return@withContext cards
        }
    }

    suspend fun getCard(cardNumber: String): DigimonCard? {
        return withContext(Dispatchers.IO) {
            cardDB[cardNumber]?.let {
                return@withContext it
            }

            val card = digimonCardApi.getCards(
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
            ).map { DigimonCard.from(it) }.firstOrNull()

            card?.let {
                cardDB[cardNumber] = it
                return@withContext it
            }

            return@withContext null
        }
    }

    suspend fun getAllCards(
        sort: String? = null,
        seriesName: String? = null,
        sortDirection: String? = null
    ): List<DigimonCard> {
        return withContext(Dispatchers.IO) {
            return@withContext digimonCardApi.getAllCards(sort, seriesName, sortDirection)
                .map { DigimonCard.from(it) }
        }
    }
}