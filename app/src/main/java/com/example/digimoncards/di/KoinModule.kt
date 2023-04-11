package com.example.digimoncards.di

import com.example.digimoncards.api.DigimonCardRepository
import com.example.digimoncards.ui.dashboard.DashboardViewModel
import com.example.digimoncards.ui.home.HomeViewModel
import com.example.digimoncards.ui.notifications.NotificationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    //single { RetrofitUtils.createDigimonCardApi() }
    singleOf(::DigimonCardRepository)
    viewModelOf(::HomeViewModel)
    viewModelOf(::DashboardViewModel)
    viewModelOf(::NotificationsViewModel)
}
