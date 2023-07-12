package com.kma.weatherexam.viewmodel.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.kma.weatherexam.api.CallbackResponse
import com.kma.weatherexam.api.LocationRepo
import com.kma.weatherexam.response.location.LocationResItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocationViewModel(private val repository: LocationRepo): ViewModel() {

    var resultLocation = MutableLiveData<LocationResItem>()

    fun getLocationSearch(name: String){
        viewModelScope.launch(Dispatchers.IO) {
            val dataInit = repository.reqLocation(name)
            resultLocation.postValue(dataInit)
        }
    }

    fun clear(){
        resultLocation = MutableLiveData<LocationResItem>()
    }

}