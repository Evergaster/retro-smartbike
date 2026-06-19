package com.smartbike.retrofit.ui.components

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.smartbike.retrofit.utils.hasPhysicalNavigationKeys

/**
 * TopBar que muestra un botón "Atrás" en la app si el sistema NO provee teclas físicas.
 * onBack puede ser null para indicar que no hay acción de retroceso manejada por la pantalla.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdaptiveTopBar(title: String, onBack: (() -> Unit)? = null) {
    val ctx: Context = LocalContext.current
    val showBack = onBack != null && !ctx.hasPhysicalNavigationKeys()

    val navIcon: @Composable () -> Unit = if (showBack) {
        {
            IconButton(onClick = { onBack() }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Atrás")
            }
        }
    } else {
        {}
    }

    TopAppBar(
        title = { Text(title) },
        navigationIcon = navIcon,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = MaterialTheme.colorScheme.onBackground
        )
    )
}

