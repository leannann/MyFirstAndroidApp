package com.example.myapplication.data.apps.dto

data class AppDto(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val rating: Float,
    val iconUrl: String?
)