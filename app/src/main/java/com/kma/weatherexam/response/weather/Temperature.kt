package com.kma.weatherexam.response.weather

data class Temperature(
    val coord: Coord,
    val main: MainTemperature,
    val weather: List<Weather>
)