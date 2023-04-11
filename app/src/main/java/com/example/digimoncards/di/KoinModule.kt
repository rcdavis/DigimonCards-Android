package com.example.digimoncards.di

import com.example.digimoncards.api.util.RetrofitUtils
import com.example.digimoncards.ui.dashboard.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    //single { RetrofitUtils.createDigimonCardApi() }
    viewModelOf(::DashboardViewModel)
}
