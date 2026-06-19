package com.smartbike.retrofit.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ScreenBackground(content: @Composable BoxScope.() -> Unit) {
    AppBackground {
        Box(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}

