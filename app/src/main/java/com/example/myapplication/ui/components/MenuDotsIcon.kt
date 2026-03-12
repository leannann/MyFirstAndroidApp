package com.example.myapplication.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MenuDotsIcon() {
    Canvas(modifier = Modifier.size(18.dp)) {
        val dotRadius = size.minDimension / 12f
        val step = size.minDimension / 2.5f

        val startX = size.width / 2f - step
        val startY = size.height / 2f - step

        for (row in 0..2) {
            for (col in 0..2) {
                drawCircle(
                    color = Color.White,
                    radius = dotRadius,
                    center = androidx.compose.ui.geometry.Offset(
                        x = startX + col * step,
                        y = startY + row * step
                    )
                )
            }
        }
    }
}