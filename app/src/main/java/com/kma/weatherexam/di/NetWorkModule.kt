package com.kma.weatherexam.di

import com.kma.weatherexam.network.createBasicAuthService
import org.koin.dsl.module

val NetWorkModule = module {
    single { createBasicAuthService() }
}