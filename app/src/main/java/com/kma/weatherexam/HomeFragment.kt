package com.kma.weatherexam

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kma.weatherexam.viewmodel.model.ForeCastViewModel
import com.kma.weatherexam.viewmodel.model.LocationViewModel
import com.kma.weatherexam.viewmodel.model.WeatherViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment(): Fragment() {

    private var adapterFore = ForeCastAdapter()

    private val viewModelForeCast: ForeCastViewModel by viewModel()

    private val viewModelWeather: WeatherViewModel by viewModel()

    private val viewModelLocation : LocationViewModel by viewModel()

    private var isClick = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findWeather("13.7525", "100.4935")
        initView("13.7525", "100.4935")
        searchViewController()
    }


    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    private fun initView(lat: String, lon: String){
        activity?.let {
            viewModelForeCast.foreCastCall(lat, lon)
            viewModelForeCast.foreCastLive.observe(viewLifecycleOwner, Observer {
                adapterFore.updateItems(it)
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = adapterFore
                }
            })
        }
    }

    private fun searchViewController(){
        searchButton.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                locationText.text = query
                searchLocation(query.toString())
                searchButton.setQuery("", false)
                searchButton.isIconified = true
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun searchLocation(name: String){

        activity.let {
            viewModelLocation.getLocationSearch(name)
            viewModelLocation.resultLocation.observe(viewLifecycleOwner, Observer {
                findWeather(it.lat.toString(), it.lon.toString())
                adapterFore.clearItem()
                viewModelForeCast.clear()
                initView(it.lat.toString(), it.lon.toString())
            })
        }

    }

    @SuppressLint("SetTextI18n")
    private fun findWeather(lat: String, lon: String){
        activity.let {
            viewModelWeather.callWeather(lat, lon)
            viewModelWeather.weatherLive.observe(viewLifecycleOwner, Observer {
                if(it.celSi.toInt() > 28){
                    rootFragment.setBackgroundResource(R.drawable.freash_temp_bg)
                }
                else{
                    rootFragment.setBackgroundResource(R.drawable.lonely_temp_bg)
                }
                textTempera.text = "${it.celSi} C ํ"
                clickChange(it.celSi, it.fahRen)
                if(it.weatherDis == "Clouds" || it.celSi.toInt() > 23){
                    iconWeather.setImageResource(R.drawable.baseline_wb_sunny_24)
                }
                else{
                    iconWeather.setImageResource(R.drawable.baseline_wb_cloudy_24)
                }
            })
        }

    }


    @SuppressLint("SetTextI18n")
    private fun clickChange(celsius: String, fahrenheit: String){

        textTempera.setOnClickListener {
            if(isClick){
                textTempera.text = "$celsius C ํ"
                isClick = false
            }
            else{
                textTempera.text = "$fahrenheit F ํ"
                isClick = true
            }
        }


    }

}