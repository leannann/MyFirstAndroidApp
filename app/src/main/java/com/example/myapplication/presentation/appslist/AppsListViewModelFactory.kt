package com.example.myapplication.presentation.appslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.apps.repository.AppsRepositoryImpl
import com.example.myapplication.data.apps.source.FakeAppsLocalDataSource
import com.example.myapplication.domain.apps.usecase.GetAppsUseCase

class AppsListViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dataSource = FakeAppsLocalDataSource()
        val repository = AppsRepositoryImpl(dataSource)
        val useCase = GetAppsUseCase(repository)

        @Suppress("UNCHECKED_CAST")
        return AppsListViewModel(useCase) as T
    }
}