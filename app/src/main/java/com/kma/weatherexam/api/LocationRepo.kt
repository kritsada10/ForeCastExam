package com.kma.weatherexam.api

import com.kma.weatherexam.response.location.LocationResItem

interface LocationRepo {

    suspend fun reqLocation(nameLocation: String): LocationResItem

}