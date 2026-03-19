package com.example.myapplication.presentation.appslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.apps.model.App
import com.example.myapplication.domain.apps.usecase.GetAppsUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AppsListViewModel(
    getAppsUseCase: GetAppsUseCase
) : ViewModel() {

    private val allApps: List<App> = getAppsUseCase()

    private val _state = MutableStateFlow(
        AppsListUiState(
            searchQuery = "",
            apps = allApps
        )
    )
    val state: StateFlow<AppsListUiState> = _state.asStateFlow()

    private val eventsChannel = Channel<AppsListEvent>(Channel.BUFFERED)
    val events: Flow<AppsListEvent> = eventsChannel.receiveAsFlow()

    fun onSearchQueryChanged(query: String) {
        val q = query.trimStart()
        _state.update {
            it.copy(
                searchQuery = q,
                apps = filterApps(allApps, q)
            )
        }
    }

    fun onLogoClick() {
        viewModelScope.launch { eventsChannel.send(AppsListEvent.ShowLogoSnack) }
    }

    private fun filterApps(source: List<App>, query: String): List<App> {
        if (query.isBlank()) return source
        return source.filter { app ->
            app.title.contains(query, ignoreCase = true) ||
                    app.description.contains(query, ignoreCase = true) ||
                    app.category.contains(query, ignoreCase = true)
        }
    }
}