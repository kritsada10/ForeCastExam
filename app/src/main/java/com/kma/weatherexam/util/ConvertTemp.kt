package com.kma.weatherexam.util

import kotlin.math.roundToInt


fun toFahrenheit(value: Double): String{

    val calculate = (1.8 * (value - 273) + 32)
    val solution:Double = (calculate * 10.0).roundToInt() / 10.0
    return solution.toString()
}

fun toCelsius(value: Double): String{
    val calculate = (((value - 32) * 5) / 9)
    val solution: Int = (calculate * 10).roundToInt() / 10
    return solution.toString()
}

