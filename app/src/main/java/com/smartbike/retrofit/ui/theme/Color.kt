package com.smartbike.retrofit.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Nueva paleta oscura de contraste profundo
val BackgroundDeep = Color(0xFF000000)
val BackgroundDeepVariant = Color(0xFF1A1A22)
val CardBackground = Color(0xFF242C3C)
val CardBorder = Color(0xFF374151)
val TextPrimary = Color(0xFFFFFFFF)
val TextSecondary = Color(0xFFE5E7EB)
val AccentCold = Color(0xFF3A8CFF)
val AccentWarm = Color(0xFFD35400)
val TextOnWarm = Color(0xFF000000)
val Critical = Color(0xFFE74C3C)

// Aliases para compatibilidad
val SmartBikeBackground = BackgroundDeep
val SmartBikeSurface = CardBackground
val SmartBikeSurfaceVariant = CardBackground
val SmartBikeOnBackground = TextPrimary
val SmartBikeOnSurface = TextSecondary
val SmartBikePrimary = AccentCold
val SmartBikePrimaryVariant = AccentCold
val SmartBikeOnPrimary = TextPrimary
val SmartBikeDivider = CardBorder
val SmartBikeOverlay = BackgroundDeepVariant
val SmartBikeDisabled = TextSecondary
val SmartBikeMuted = TextSecondary
val SmartBikeSubtleText = TextSecondary
val SmartBikeMap = BackgroundDeep
val SmartBikeMapStreet = BackgroundDeepVariant
val SmartBikeSuccess = AccentCold
val SmartBikeWarning = Critical
val SmartBikeError = Critical

// Gradientes
val RedGradient: Brush = Brush.linearGradient(colors = listOf(AccentWarm, AccentCold))
val CardActiveGradient: Brush = Brush.linearGradient(colors = listOf(CardBackground, BackgroundDeep))
val AppBarGradient: Brush = Brush.verticalGradient(colors = listOf(BackgroundDeep, BackgroundDeepVariant))
val ProgressGoodGradient: Brush = Brush.linearGradient(colors = listOf(AccentCold, AccentCold))
val ProgressWarningGradient: Brush = Brush.linearGradient(colors = listOf(Critical, AccentWarm))
val ProgressCriticalGradient: Brush = Brush.linearGradient(colors = listOf(Critical, BackgroundDeep))
val GlassCardGradient: Brush = Brush.linearGradient(colors = listOf(CardBackground, CardBackground))
val GlassCardBorderGradient: Brush = Brush.linearGradient(colors = listOf(CardBorder, CardBorder))
