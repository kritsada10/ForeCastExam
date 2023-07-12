package com.kma.weatherexam.viewmodel.impl

import android.util.Log
import com.kma.weatherexam.api.ForeCastRepo
import com.kma.weatherexam.api.RouteAPI
import com.kma.weatherexam.response.forecast.ForeCastResponse
import com.kma.weatherexam.util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class ForeCastImpl(private val api: RouteAPI): ForeCastRepo {
    override suspend fun reqForeCast(lat: String, lon: String, key: String): ForeCastResponse {
        val dataResult = CoroutineScope(Dispatchers.IO).async {
             val responseModel = api.getDaily(lat = lat, lon = lon, key = Constants.API_KEY)
            return@async responseModel.body()
        }
        return dataResult.await()!!
    }
}