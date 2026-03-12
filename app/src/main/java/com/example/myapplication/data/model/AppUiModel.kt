package com.example.myapplication.data.model

data class AppUiModel(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val rating: Float,
    val iconUrl: String? = null,
    val iconPlaceholderSeed: Int = id
)