package com.example.myapplication.feature.appslist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.AppUiModel
import com.example.myapplication.data.repository.AppsRepository
import com.example.myapplication.data.repository.FakeAppsRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AppsListViewModel : ViewModel() {

    private val repository: AppsRepository = FakeAppsRepository

    private val allApps: List<AppUiModel> = repository.getApps()

    private val _state = MutableStateFlow(
        AppsListUiState(
            searchQuery = "",
            apps = allApps
        )
    )
    val state: StateFlow<AppsListUiState> = _state.asStateFlow()

    private val eventsChannel = Channel<AppsListEvent>(capacity = Channel.BUFFERED)
    val events: Flow<AppsListEvent> = eventsChannel.receiveAsFlow()

    fun onSearchQueryChanged(query: String) {
        val trimmed = query.trimStart()
        _state.update {
            it.copy(
                searchQuery = trimmed,
                apps = filterApps(allApps, trimmed)
            )
        }
    }

    fun onLogoClick() {
        viewModelScope.launch {
            eventsChannel.send(AppsListEvent.ShowLogoSnack)
        }
    }

    private fun filterApps(source: List<AppUiModel>, query: String): List<AppUiModel> {
        if (query.isBlank()) return source

        val q = query.trim()
        return source.filter { app ->
            app.title.contains(q, ignoreCase = true) ||
                    app.description.contains(q, ignoreCase = true) ||
                    app.category.contains(q, ignoreCase = true)
        }
    }
}