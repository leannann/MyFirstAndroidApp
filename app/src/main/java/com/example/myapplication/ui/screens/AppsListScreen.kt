package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.presentation.appslist.AppsListEvent
import com.example.myapplication.presentation.appslist.AppsListViewModel
import com.example.myapplication.presentation.appslist.AppsListViewModelFactory
import com.example.myapplication.ui.components.*
import com.example.myapplication.ui.util.UiDimens
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AppsListScreen(
    onAppClick: (Int) -> Unit
) {
    val viewModel: AppsListViewModel = viewModel(factory = AppsListViewModelFactory())
    val state by viewModel.state.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.events.collectLatest { event ->
            when (event) {
                AppsListEvent.ShowLogoSnack -> {
                    snackbarHostState.showSnackbar("Логотип RuStore")
                }
            }
        }
    }

    Scaffold(
        topBar = {
            RuStoreTopBar(
                onLogoClick = viewModel::onLogoClick,
                onMenuClick = {}
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color(0xFFF3F5F8))
                .padding(UiDimens.ScreenPadding)
        ) {
            Card(
                shape = androidx.compose.foundation.shape.RoundedCornerShape(UiDimens.CardCorner),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column {
                    Box(modifier = Modifier.padding(UiDimens.SearchPadding)) {
                        SearchField(
                            value = state.searchQuery,
                            onValueChange = viewModel::onSearchQueryChanged
                        )
                    }

                    LazyColumn {
                        itemsIndexed(state.apps) { index, app ->
                            AppListItem(
                                app = app,
                                onClick = { clicked ->
                                    onAppClick(clicked.id)
                                }
                            )
                            if (index != state.apps.lastIndex) {
                                AppListDivider()
                            }
                        }
                    }
                }
            }
        }
    }
}