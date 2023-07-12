package com.kma.weatherexam.di

import com.kma.weatherexam.api.ForeCastRepo
import com.kma.weatherexam.api.LocationRepo
import com.kma.weatherexam.api.WeatherRepo
import com.kma.weatherexam.viewmodel.impl.ForeCastImpl
import com.kma.weatherexam.viewmodel.impl.LocationImpl
import com.kma.weatherexam.viewmodel.model.LocationViewModel
import com.kma.weatherexam.viewmodel.impl.WeatherImpl
import com.kma.weatherexam.viewmodel.model.ForeCastViewModel
import com.kma.weatherexam.viewmodel.model.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {

    single<WeatherRepo> { WeatherImpl(get()) }

    single<LocationRepo> { LocationImpl(get()) }

    single<ForeCastRepo> { ForeCastImpl(get()) }

    viewModel { WeatherViewModel(get()) }

    viewModel { LocationViewModel(get()) }

    viewModel { ForeCastViewModel(get()) }

}