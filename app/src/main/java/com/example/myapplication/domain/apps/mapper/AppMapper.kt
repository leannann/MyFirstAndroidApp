package com.example.myapplication.data.apps.mapper

import com.example.myapplication.data.apps.dto.AppDto
import com.example.myapplication.domain.apps.model.App

object AppMapper {
    fun toDomain(dto: AppDto): App =
        App(
            id = dto.id,
            title = dto.title,
            description = dto.description,
            category = dto.category,
            rating = dto.rating,
            iconUrl = dto.iconUrl
        )
}