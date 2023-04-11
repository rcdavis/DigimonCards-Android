package com.example.digimoncards.api

import com.example.digimoncards.api.dto.DigimonCardDto
import java.net.URL

data class DigimonCard(
    val number: String,
    val name: String,
    val type: CardType,
    val color: CardColor,
    val stage: String, // TODO: Make Enum?
    val digiType: String, // TODO: Make Enum?
    val attribute: String, // TODO: Make Enum?
    val level: Int,
    val playCost: Int,
    val evolutionCost: Int,
    val cardRarity: String,
    val artist: String,
    val dp: Int,
    val mainEffect: String,
    val sourceEffect: String?,
    val setName: String,
    val cardSets: List<String>,
    val imageUrl: URL
) {
    companion object {
        fun from(dto: DigimonCardDto): DigimonCard {
            return DigimonCard(
                dto.cardnumber,
                dto.name,
                CardType.valueOf(dto.type),
                CardColor.valueOf(dto.color),
                dto.stage,
                dto.digi_type,
                dto.attribute,
                dto.level,
                dto.play_cost,
                dto.evolution_cost,
                dto.cardrarity,
                dto.artist,
                dto.dp,
                dto.maineffect,
                dto.sourceeffect,
                dto.set_name,
                dto.card_sets,
                URL(dto.image_url)
            )
        }
    }
}
