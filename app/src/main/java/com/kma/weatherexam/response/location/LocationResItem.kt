package com.kma.weatherexam.response.location

data class LocationResItem(
    val country: String = "",
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val name: String = "",
    val state: String = ""
)