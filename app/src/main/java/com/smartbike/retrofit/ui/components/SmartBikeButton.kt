package com.smartbike.retrofit.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartbike.retrofit.ui.theme.ButtonPrimaryGradient
import com.smartbike.retrofit.ui.theme.TitleFont

@Composable
fun SmartBikeButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val shape = RoundedCornerShape(16.dp)
    val primaryColor = MaterialTheme.colorScheme.primary
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.97f else 1f,
        animationSpec = tween(durationMillis = 120),
        label = "smart_bike_button_scale"
    )

    val alpha = if (enabled) 1f else 0.4f

    Box(
        modifier = modifier
            .fillMaxWidth()
            .scale(if (enabled) scale else 1f)
            .clip(shape)
            .graphicsLayer {
                shadowElevation = if (enabled) 8.dp.toPx() else 0.dp.toPx()
                ambientShadowColor = primaryColor.copy(alpha = if (enabled) 0.4f else 0f)
                spotShadowColor = primaryColor.copy(alpha = if (enabled) 0.4f else 0f)
                this.alpha = alpha
            }
            .background(brush = ButtonPrimaryGradient)
            .drawWithContent {
                drawContent()
                drawRect(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0x08FFFFFF), Color(0x00FFFFFF)),
                        start = Offset(0f, 0f),
                        end = Offset(0f, size.height)
                    )
                )
            }
            .then(
                if (enabled) Modifier.clickable(interactionSource = interactionSource, indication = null, onClick = onClick)
                else Modifier
            )
            .defaultMinSize(minHeight = 56.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontFamily = TitleFont,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.5.sp,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp)
        )
    }
}
