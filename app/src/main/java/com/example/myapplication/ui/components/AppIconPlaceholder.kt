package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.myapplication.ui.util.UiDimens
import kotlin.math.abs

@Composable
fun AppIconPlaceholder(
    title: String,
    seed: Int
) {
    val colors = listOf(
        Color(0xFFE8F0FE),
        Color(0xFFEAF7E9),
        Color(0xFFFFF3E0),
        Color(0xFFF3E5F5),
        Color(0xFFE0F7FA)
    )
    val bg = colors[abs(seed) % colors.size]
    val letter = title.trim().firstOrNull()?.uppercase() ?: "A"

    Box(
        modifier = Modifier
            .size(UiDimens.ItemIconSize)
            .background(bg, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = letter,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF2E2E2E)
        )
    }
}