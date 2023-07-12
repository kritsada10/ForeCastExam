package com.kma.weatherexam.api

import com.kma.weatherexam.response.weather.ResultWeather

interface WeatherRepo {

    suspend fun reqWeather(lat: String, lon: String, key: String): ResultWeather

}