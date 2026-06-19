package com.smartbike.retrofit.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsBike
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.smartbike.retrofit.ui.theme.SmartBikePrimary

@Composable
fun BikeMarker(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(34.dp)
            .graphicsLayer {
                shadowElevation = 8.dp.toPx()
                ambientShadowColor = SmartBikePrimary.copy(alpha = 0.38f)
                spotShadowColor = SmartBikePrimary.copy(alpha = 0.38f)
            }
            .background(SmartBikePrimary, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.DirectionsBike,
            contentDescription = "Marker",
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(18.dp)
        )
    }
}

