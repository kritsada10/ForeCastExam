package com.kma.weatherexam.request

data class ReqWeather(
    val latitude: String,
    val longitude: String,
    val apiKey: String
)