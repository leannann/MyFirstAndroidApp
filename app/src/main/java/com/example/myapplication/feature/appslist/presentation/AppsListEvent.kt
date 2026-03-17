package com.example.myapplication.feature.appslist.presentation

sealed interface AppsListEvent {
    data object ShowLogoSnack : AppsListEvent
}