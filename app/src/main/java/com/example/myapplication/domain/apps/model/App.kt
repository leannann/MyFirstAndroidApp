package com.example.myapplication.domain.apps.model

data class App(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val rating: Float,
    val iconUrl: String?
)