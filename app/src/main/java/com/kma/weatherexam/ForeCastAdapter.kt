package com.kma.weatherexam

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.kma.weatherexam.response.forecast.ForeCastResponse
import com.kma.weatherexam.response.forecast.ResultForeCast
import com.kma.weatherexam.util.toCelsius
import com.kma.weatherexam.util.toFahrenheit
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForeCastAdapter: RecyclerView.Adapter<ForeCastAdapter.ViewHolder>() {

    private var arrayFore: ArrayList<ResultForeCast> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(items: ArrayList<ResultForeCast>) {
        this.arrayFore = items
        notifyDataSetChanged()
    }

    fun clearItem(){
        this.arrayFore.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return arrayFore.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tempeDaily = arrayFore[position].temp
        val dateTimeDaily = arrayFore[position].dateTime
        val foreCastIcon = arrayFore[position].weatherDis

        val fahrenheit = toFahrenheit(tempeDaily)
        val celsius = toCelsius(fahrenheit.toDouble())

        holder.initViewFore(celsius,fahrenheit,dateTimeDaily,foreCastIcon)
    }



    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        //private lateinit var iconImage : ImageView

        @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
        fun initViewFore(celsius: String, fahrenheit: String, date: String, icon: String){

            view.dateTimeItem.text = date
            view.celsiusItem.text = celsius + "C ํ"
            view.fahrenheitItem.text = fahrenheit + "F ํ"
            //iconImage = view.findViewById(R.id.iconWeather)
            if(icon == "Clouds"){
                view.sunItem.setImageResource(R.drawable.baseline_wb_sunny_24)
            }
            else{
                view.sunItem.setImageResource(R.drawable.baseline_wb_cloudy_24)
            }

        }


    }


}