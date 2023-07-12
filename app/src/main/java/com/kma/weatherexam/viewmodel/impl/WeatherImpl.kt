package com.kma.weatherexam.viewmodel.impl

import android.util.Log
import com.kma.weatherexam.util.Constants
import com.kma.weatherexam.request.ReqWeather
import com.kma.weatherexam.api.RouteAPI
import com.kma.weatherexam.api.WeatherRepo
import com.kma.weatherexam.response.weather.ResultWeather
import com.kma.weatherexam.util.toCelsius
import com.kma.weatherexam.util.toFahrenheit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class WeatherImpl(private val api: RouteAPI) : WeatherRepo {

    override suspend fun reqWeather(lat: String, lon: String, key: String): ResultWeather {
        val dataResult = CoroutineScope(Dispatchers.IO).async {
            val insWeather = api.getWeather(lat = lat, lon = lon, key = Constants.API_KEY)
            val tempKelvin = insWeather.body()?.main?.temp
            val weatherDis = insWeather.body()?.weather?.get(0)?.main
            val humidityResult = insWeather.body()?.main?.humidity
            val fahRen = toFahrenheit(tempKelvin!!)
            val celsius = toCelsius(fahRen.toDouble())
            return@async ResultWeather(
                fahRen = fahRen, celSi = celsius,
                humidity = humidityResult.toString(), weatherDis = weatherDis.toString()
            )
        }
        return dataResult.await()
    }
}