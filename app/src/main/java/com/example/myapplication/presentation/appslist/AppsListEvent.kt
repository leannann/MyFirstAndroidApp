package com.example.myapplication.presentation.appslist

sealed interface AppsListEvent {
    data object ShowLogoSnack : AppsListEvent
}