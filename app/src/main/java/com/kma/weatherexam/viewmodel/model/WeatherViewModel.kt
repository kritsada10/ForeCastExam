package com.kma.weatherexam.viewmodel.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kma.weatherexam.util.Constants
import com.kma.weatherexam.api.WeatherRepo
import com.kma.weatherexam.response.weather.ResultWeather
import com.kma.weatherexam.response.weather.Temperature
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepo): ViewModel() {

    var weatherLive = MutableLiveData<ResultWeather>()

    fun callWeather(lat: String, lon: String){
        viewModelScope.launch(Dispatchers.IO) {
            val receiveData = repository.reqWeather(lat = lat, lon = lon, key = Constants.API_KEY)
            weatherLive.postValue(receiveData)
        }
    }

    fun clear(){
        weatherLive = MutableLiveData<ResultWeather>()
    }

}