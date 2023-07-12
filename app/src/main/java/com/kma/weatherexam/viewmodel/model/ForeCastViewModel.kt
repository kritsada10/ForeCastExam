package com.kma.weatherexam.viewmodel.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kma.weatherexam.api.ForeCastRepo
import com.kma.weatherexam.response.forecast.ForeCastResponse
import com.kma.weatherexam.response.forecast.ResultForeCast
import com.kma.weatherexam.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ForeCastViewModel(private val repository: ForeCastRepo): ViewModel() {

    var foreCastLive = MutableLiveData<ArrayList<ResultForeCast>>()

    private val resultInit : ArrayList<ResultForeCast> = ArrayList()

    fun foreCastCall(lat: String, lon: String){
        viewModelScope.launch(Dispatchers.IO) {
            val receiveData = repository.reqForeCast(lat = lat, lon = lon, key = Constants.API_KEY)
            for (i in receiveData.list.indices){
                for (j in receiveData.list[i].weather.indices){
                    val dataAssign = ResultForeCast(temp = receiveData.list[i].main.temp,
                        dateTime = receiveData.list[i].dt_txt, weatherDis = receiveData.list[i].weather[j].main)
                    resultInit.add(dataAssign)
                }
            }
            foreCastLive.postValue(resultInit)
        }
    }

    fun clear(){
        foreCastLive = MutableLiveData<ArrayList<ResultForeCast>>()
    }

}