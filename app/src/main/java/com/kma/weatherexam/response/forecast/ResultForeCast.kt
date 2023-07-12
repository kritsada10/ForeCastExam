package com.kma.weatherexam.response.forecast

data class ResultForeCast(
    val temp: Double = 0.0,
    val dateTime: String = "",
    val weatherDis: String = ""
)