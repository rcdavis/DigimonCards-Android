package com.example.digimoncards.api.dto

data class DigimonCardDto(
    val name: String,
    val type: String,
    val color: String,
    val stage: String,
    val digi_type: String,
    val attribute: String,
    val level: Int,
    val play_cost: Int,
    val evolution_cost: Int,
    val cardrarity: String,
    val artist: String,
    val dp: Int,
    val cardnumber: String,
    val maineffect: String,
    val sourceeffect: String?,
    val set_name: String,
    val card_sets: List<String>,
    val image_url: String
)
