package com.kma.weatherexam

import android.app.Application
import com.kma.weatherexam.di.FragmentModule
import com.kma.weatherexam.di.NetWorkModule
import com.kma.weatherexam.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin


class MainApp: Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            //androidLogger()
            androidContext(this@MainApp)
            fragmentFactory()
            modules(listOf(NetWorkModule , ViewModelModule, FragmentModule))
        }
    }

}