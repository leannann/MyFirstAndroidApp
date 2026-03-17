package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.myapplication.ui.util.UiDimens

@Composable
fun RatingBadge(
    ratingText: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = ratingText,
        fontWeight = FontWeight.Medium,
        color = Color(0xFF2E2E2E),
        modifier = modifier
            .background(
                color = Color(0xFFF2F4F7),
                shape = RoundedCornerShape(UiDimens.RatingCorner)
            )
            .padding(
                horizontal = UiDimens.RatingHPadding,
                vertical = UiDimens.RatingVPadding
            )
    )
}