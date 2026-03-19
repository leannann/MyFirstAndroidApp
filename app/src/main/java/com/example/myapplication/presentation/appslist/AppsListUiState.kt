package com.example.myapplication.presentation.appslist

import com.example.myapplication.domain.apps.model.App

data class AppsListUiState(
    val searchQuery: String = "",
    val apps: List<App> = emptyList()
)