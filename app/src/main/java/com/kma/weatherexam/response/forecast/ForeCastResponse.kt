package com.kma.weatherexam.response.forecast

data class ForeCastResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<EmptyListFore>,
    val message: Int
)