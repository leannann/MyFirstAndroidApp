package com.example.myapplication.domain.apps.repository

import com.example.myapplication.domain.apps.model.App

interface AppsRepository {
    fun getApps(): List<App>
    fun getAppById(id: Int): App?
}