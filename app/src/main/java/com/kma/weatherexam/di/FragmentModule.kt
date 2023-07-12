package com.kma.weatherexam.di

import com.kma.weatherexam.HomeFragment
import com.kma.weatherexam.api.ServiceFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val FragmentModule = module {

    fragment { HomeFragment() }

}