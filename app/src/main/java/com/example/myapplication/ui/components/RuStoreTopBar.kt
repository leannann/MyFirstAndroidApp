package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.util.UiDimens

@Composable
fun RuStoreTopBar(
    onLogoClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    Surface(color = Color(0xFF3D6AE6)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(
                    horizontal = UiDimens.TopBarHPadding,
                    vertical = UiDimens.TopBarVPadding
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(UiDimens.TopBarLogoSize)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White.copy(alpha = 0.18f))
                    .clickable(onClick = onLogoClick)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "RuStore",
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.weight(1f))

            MenuButton(onClick = onMenuClick)
        }
    }
}