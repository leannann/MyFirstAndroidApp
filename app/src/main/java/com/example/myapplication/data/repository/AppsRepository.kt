package com.example.myapplication.data.repository

import com.example.myapplication.data.model.AppUiModel

interface AppsRepository {
    fun getApps(): List<AppUiModel>
    fun getAppById(id: Int): AppUiModel?
}