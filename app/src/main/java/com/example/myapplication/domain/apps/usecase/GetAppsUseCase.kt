package com.example.myapplication.domain.apps.usecase

import com.example.myapplication.domain.apps.model.App
import com.example.myapplication.domain.apps.repository.AppsRepository

class GetAppsUseCase(
    private val repository: AppsRepository
) {
    operator fun invoke(): List<App> = repository.getApps()
}