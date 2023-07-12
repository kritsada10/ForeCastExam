package com.kma.weatherexam.api

import com.kma.weatherexam.response.forecast.ForeCastResponse
import com.kma.weatherexam.response.location.LocationRes
import com.kma.weatherexam.response.weather.Temperature
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RouteAPI {

    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") key: String
    ): Response<Temperature>

    @GET("geo/1.0/direct")
    suspend fun getLocation(
        @Query("q") location: String,
        @Query("limit") limit: String,
        @Query("appid") key: String
    ): Response<LocationRes>

    @GET("data/2.5/forecast")
    suspend fun getDaily(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") key: String
    ): Response<ForeCastResponse>
}