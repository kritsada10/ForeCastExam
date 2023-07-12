package com.kma.weatherexam.viewmodel.impl

import android.util.Log
import com.kma.weatherexam.api.CallbackResponse
import com.kma.weatherexam.api.LocationRepo
import com.kma.weatherexam.api.RouteAPI
import com.kma.weatherexam.response.location.LocationRes
import com.kma.weatherexam.response.location.LocationResItem
import com.kma.weatherexam.util.Constants.API_KEY
import com.kma.weatherexam.viewmodel.model.LocationViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LocationImpl(private val api: RouteAPI): LocationRepo {

    override suspend fun reqLocation(nameLocation: String): LocationResItem {
        val resultData = CoroutineScope(Dispatchers.IO).async {
            var locationResult = LocationResItem()
             val resApi = api.getLocation(nameLocation, "1", API_KEY)
            if(!resApi.body().isNullOrEmpty()){
                locationResult = resApi.body()!![0]
            }
            return@async locationResult
        }
        return resultData.await()
    }

}