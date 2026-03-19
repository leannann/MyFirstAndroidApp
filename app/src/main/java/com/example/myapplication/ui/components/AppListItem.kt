package com.example.myapplication.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.apps.model.App
import com.example.myapplication.ui.util.UiDimens

@Composable
fun AppListItem(
    app: App,
    onClick: (App) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(app) }
            .padding(
                horizontal = UiDimens.ItemHPadding,
                vertical = UiDimens.ItemVPadding
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppIconPlaceholder(title = app.title, seed = app.id)

        Spacer(modifier = Modifier.width(UiDimens.ItemSpacing))

        Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = app.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF1F1F1F),
                    modifier = Modifier.weight(1f)
                )
                RatingBadge(ratingText = formatRating(app.rating))
            }

            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = app.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF6B7280)
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = app.category,
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF8B93A1)
            )
        }
    }
}

@Composable
fun AppListDivider() {
    Divider(
        thickness = 1.dp,
        color = Color(0xFFE6E8EC)
    )
}

private fun formatRating(rating: Float): String {
    return String.format(java.util.Locale.US, "%.1f", rating).replace('.', ',')
}