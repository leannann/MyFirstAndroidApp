package com.example.myapplication.data.apps.repository

import com.example.myapplication.data.apps.mapper.AppMapper
import com.example.myapplication.data.apps.source.AppsLocalDataSource
import com.example.myapplication.domain.apps.model.App
import com.example.myapplication.domain.apps.repository.AppsRepository

class AppsRepositoryImpl(
    private val localDataSource: AppsLocalDataSource
) : AppsRepository {

    override fun getApps(): List<App> =
        localDataSource.getApps().map(AppMapper::toDomain)

    override fun getAppById(id: Int): App? =
        localDataSource.getAppById(id)?.let(AppMapper::toDomain)
}