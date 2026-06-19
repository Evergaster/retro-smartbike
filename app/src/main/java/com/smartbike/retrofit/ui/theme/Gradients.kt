package com.smartbike.retrofit.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val BackgroundGradient: Brush = Brush.verticalGradient(
    colors = listOf(BackgroundDeep, BackgroundDeepVariant)
)

val HeroGradient: Brush = Brush.verticalGradient(
    colors = listOf(BackgroundDeep, BackgroundDeepVariant)
)

val ButtonPrimaryGradient: Brush = Brush.linearGradient(
    colors = listOf(AccentWarm, AccentCold),
    start = Offset(0f, 0f),
    end = Offset(1200f, 0f)
)

val ProgressGradient: Brush = Brush.linearGradient(
    colors = listOf(AccentCold, AccentCold)
)

val ProgressWarning: Brush = Brush.linearGradient(
    colors = listOf(Critical, AccentWarm)
)

val ProgressCritical: Brush = Brush.linearGradient(
    colors = listOf(Critical, BackgroundDeep)
)

val FabGradient: Brush = Brush.radialGradient(
    colors = listOf(AccentWarm, AccentCold)
)

val GlowTopLeft: Brush = Brush.radialGradient(
    colors = listOf(AccentCold.copy(alpha = 0.22f), Color.Transparent)
)

val GlowBottomRight: Brush = Brush.radialGradient(
    colors = listOf(AccentWarm.copy(alpha = 0.14f), Color.Transparent)
)
