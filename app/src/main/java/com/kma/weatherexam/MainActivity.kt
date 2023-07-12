package com.kma.weatherexam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kma.weatherexam.api.CallbackResponse


class MainActivity : AppCompatActivity(), CallbackResponse {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        val fragmentTran = fragmentManager.beginTransaction()
        fragmentTran.replace(R.id.container, HomeFragment())
        fragmentTran.commit()

    }

}