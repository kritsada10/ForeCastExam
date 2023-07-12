package com.kma.weatherexam.response.forecast

data class EmptyListFore (
        val clouds: Clouds,
        val dt: Int,
        val dt_txt: String,
        val main: Main,
        val pop: Float,
        val sys: Sys,
        val visibility: Int,
        val weather: List<Weather>,
        val wind: Wind
        )