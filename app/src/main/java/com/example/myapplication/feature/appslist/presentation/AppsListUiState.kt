package com.example.myapplication.feature.appslist.presentation

import com.example.myapplication.data.model.AppUiModel

data class AppsListUiState(
    val searchQuery: String = "",
    val apps: List<AppUiModel> = emptyList()
)