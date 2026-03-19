package com.example.myapplication.data.apps.source

import com.example.myapplication.data.apps.dto.AppDto

interface AppsLocalDataSource {
    fun getApps(): List<AppDto>
    fun getAppById(id: Int): AppDto?
}