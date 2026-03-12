package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppsListScreen(
    onOpenDetails: () -> Unit
) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(text = "Экран списка приложений (заглушка)")
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = onOpenDetails) {
                Text(text = "Открыть карточку (заглушка)")
            }
        }
    }
}