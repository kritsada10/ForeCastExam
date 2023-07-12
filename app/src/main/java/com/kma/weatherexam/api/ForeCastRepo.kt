package com.kma.weatherexam.api

import com.kma.weatherexam.response.forecast.ForeCastResponse
import com.kma.weatherexam.response.weather.ResultWeather

interface ForeCastRepo {

    suspend fun reqForeCast(lat: String, lon: String, key: String): ForeCastResponse

}