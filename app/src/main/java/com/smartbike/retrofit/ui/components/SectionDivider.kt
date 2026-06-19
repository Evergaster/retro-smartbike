package com.smartbike.retrofit.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.smartbike.retrofit.ui.theme.AccentWarm

@Composable
fun SectionDivider(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        AccentWarm.copy(alpha = 0f),
                        AccentWarm.copy(alpha = 0.3f),
                        AccentWarm.copy(alpha = 0f)
                    )
                )
            )
    )
}
