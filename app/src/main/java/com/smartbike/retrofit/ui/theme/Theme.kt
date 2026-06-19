package com.smartbike.retrofit.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val SmartBikeColorScheme = darkColorScheme(
    primary = AccentCold,
    onPrimary = TextPrimary,
    primaryContainer = CardBackground,
    secondary = AccentWarm,
    onSecondary = TextOnWarm,
    secondaryContainer = CardBackground,
    tertiary = AccentCold,
    background = BackgroundDeep,
    onBackground = TextPrimary,
    surface = CardBackground,
    onSurface = TextPrimary,
    surfaceVariant = CardBackground,
    outline = CardBorder,
    outlineVariant = CardBorder,
    error = Critical,
    onError = TextPrimary
)

@Composable
@Suppress("UNUSED_PARAMETER")
fun RetrofitSmartBikeTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = SmartBikeColorScheme,
        typography = SmartBikeTypography,
        shapes = SmartBikeShapes,
        content = content
    )
}
