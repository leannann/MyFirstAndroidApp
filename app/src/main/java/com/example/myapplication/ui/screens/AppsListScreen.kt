package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.myapplication.data.repository.FakeAppsRepository
import com.example.myapplication.ui.components.*
import com.example.myapplication.ui.util.UiDimens

@Composable
fun AppsListScreen(
    onAppClick: (Int) -> Unit
) {
    val apps = remember { FakeAppsRepository.getApps() }
    var searchQuery by rememberSaveable { mutableStateOf("") } // пока без фильтрации

    Column(modifier = Modifier.fillMaxSize()) {
        RuStoreTopBar(onMenuClick = {})

        Column(
            modifier = Modifier
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
                            value = searchQuery,
                            onValueChange = { searchQuery = it }
                        )
                    }

                    LazyColumn {
                        itemsIndexed(apps) { index, app ->
                            AppListItem(
                                app = app,
                                onClick = { clickedApp ->
                                    onAppClick(clickedApp.id)
                                }
                            )
                            if (index != apps.lastIndex) {
                                AppListDivider()
                            }
                        }
                    }
                }
            }
        }
    }
}