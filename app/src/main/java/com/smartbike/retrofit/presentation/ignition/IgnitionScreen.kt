package com.smartbike.retrofit.presentation.ignition

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.EaseInOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Power
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.smartbike.retrofit.ui.components.AppBackground
import com.smartbike.retrofit.ui.components.BottomNavBar
import com.smartbike.retrofit.ui.components.SmartBikeButton
import com.smartbike.retrofit.ui.components.SmartBikeCard
import com.smartbike.retrofit.ui.theme.AccentCold
import com.smartbike.retrofit.ui.theme.BackgroundDeep
import com.smartbike.retrofit.ui.theme.Critical

private enum class IgnitionState { OFF, READY, ON }

@androidx.compose.material3.ExperimentalMaterial3Api
@Composable
fun IgnitionScreen(
    navController: NavHostController,
    viewModel: IgnitionViewModel = viewModel()
) {
    var menuExpanded by remember { mutableStateOf(false) }
    val selected = viewModel.selectedVehicle
    val state = when {
        selected == null -> IgnitionState.OFF
        selected.isNeutral -> IgnitionState.READY
        else -> IgnitionState.ON
    }
    val offCenterColors = listOf(
        MaterialTheme.colorScheme.surfaceVariant,
        MaterialTheme.colorScheme.surface,
        Color.Transparent
    )

    val transition = rememberInfiniteTransition(label = "ring")
    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(9000, easing = LinearEasing), RepeatMode.Restart),
        label = "ring_rotation"
    )
    val icon = when (state) {
        IgnitionState.OFF -> Icons.Default.Lock
        IgnitionState.READY -> Icons.Default.Key
        IgnitionState.ON -> Icons.Default.Power
    }

    AppBackground {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                com.smartbike.retrofit.ui.components.AdaptiveTopBar(
                    title = "Control de Encendido",
                    onBack = { navController.navigateUp() }
                )
            },
            bottomBar = { BottomNavBar(navController) }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {

                    // ── CAPA 1: Anillo exterior animado ──────────────────────────────────
                    val scale by transition.animateFloat(
                        initialValue = 1.0f,
                        targetValue = 1.06f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(1200, easing = EaseInOut),
                            repeatMode = RepeatMode.Reverse
                        ),
                        label = "outer_ring_scale"
                    )

                    Canvas(
                        modifier = Modifier
                            .size(220.dp)
                            .rotate(rotation)
                            .scale(if (state == IgnitionState.READY) scale else 1f)
                    ) {
                        drawCircle(
                            color = AccentCold.copy(alpha = 0.35f),
                            radius = size.minDimension / 2f,
                            style = Stroke(width = 1.5.dp.toPx())
                        )
                        drawCircle(
                            brush = Brush.radialGradient(
                                colors = listOf(AccentCold.copy(alpha = 0.18f), Color.Transparent)
                            ),
                            radius = size.minDimension / 2f
                        )
                    }

                    // ── CAPA 2: Anillo medio ─────────────────────────────────────────────
                    Canvas(
                        modifier = Modifier.size(160.dp)
                    ) {
                        drawCircle(
                            brush = Brush.radialGradient(
                                colors = listOf(AccentCold.copy(alpha = 0.2f), Color.Transparent)
                            )
                        )
                        drawCircle(
                            color = AccentCold,
                            radius = size.minDimension / 2f - 1.dp.toPx(),
                            style = Stroke(width = 2.dp.toPx())
                        )
                    }

                    // ── CAPA 3: Centro ────────────────────────────────────────────────────
                    Box(
                        modifier = Modifier.size(96.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            drawCircle(
                                brush = Brush.radialGradient(
                                    colors = when (state) {
                                        IgnitionState.OFF -> offCenterColors
                                        IgnitionState.READY -> listOf(
                                            BackgroundDeep,
                                            AccentCold,
                                            Color.Transparent
                                        )
                                        IgnitionState.ON -> listOf(
                                            AccentCold,
                                            AccentCold,
                                            Color.Transparent
                                        )
                                    },
                                    radius = size.minDimension / 2f
                                )
                            )
                        }

                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = when (state) {
                                IgnitionState.OFF -> MaterialTheme.colorScheme.onSurface
                                IgnitionState.READY -> Color.White
                                IgnitionState.ON -> Color.White
                            },
                            modifier = Modifier.size(
                                when (state) {
                                    IgnitionState.ON -> 44.dp
                                    else -> 40.dp
                                }
                            )
                        )
                    }
                }

                Text(
                    text = when (state) {
                        IgnitionState.OFF -> "Apagado"
                        IgnitionState.READY -> "Listo para encender"
                        IgnitionState.ON -> "Encendido"
                    },
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                // Menú desplegable de vehículos disponibles
                Box(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = AccentCold.copy(alpha = 0.12f),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .border(
                                1.dp,
                                AccentCold.copy(alpha = 0.4f),
                                RoundedCornerShape(12.dp)
                            )
                            .clickable { menuExpanded = true }
                            .padding(horizontal = 16.dp, vertical = 14.dp)
                    ) {
                        Text(
                            text = selected?.nickname ?: "Selecciona un vehículo",
                            color = if (selected != null) Color.White else AccentCold,
                            fontWeight = FontWeight.SemiBold
                        )
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = null,
                            tint = AccentCold,
                            modifier = Modifier.align(Alignment.CenterEnd)
                        )
                    }

                    DropdownMenu(
                        expanded = menuExpanded,
                        onDismissRequest = { menuExpanded = false }
                    ) {
                        viewModel.vehicles.forEach { vehicle ->
                            DropdownMenuItem(
                                text = {
                                    Column {
                                        Text(vehicle.nickname, fontWeight = FontWeight.SemiBold)
                                        Text(
                                            text = if (vehicle.isNeutral) "Neutral" else "No neutral",
                                            color = if (vehicle.isNeutral) AccentCold else Critical,
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    }
                                },
                                onClick = {
                                    viewModel.selectVehicle(vehicle.id)
                                    menuExpanded = false
                                }
                            )
                        }
                        if (viewModel.vehicles.isEmpty()) {
                            DropdownMenuItem(
                                text = { Text("No hay vehículos registrados") },
                                onClick = { menuExpanded = false },
                                enabled = false
                            )
                        }
                    }
                }

                // Estado is_neutral del vehículo seleccionado
                if (selected != null) {
                    Box(
                        modifier = Modifier
                            .background(
                                if (selected.isNeutral) AccentCold.copy(alpha = 0.12f) else Critical.copy(alpha = 0.16f),
                                RoundedCornerShape(999.dp)
                            )
                            .border(
                                1.dp,
                                if (selected.isNeutral) AccentCold else Critical,
                                RoundedCornerShape(999.dp)
                            )
                            .padding(horizontal = 14.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = if (selected.isNeutral) "${selected.nickname} en Neutral"
                                    else "${selected.nickname} no está en Neutral",
                            color = if (selected.isNeutral) AccentCold else Critical
                        )
                    }
                }

                SmartBikeButton(
                    text = if (viewModel.isSendingCommand) "ENVIANDO..." else if (state == IgnitionState.ON) "APAGAR" else "ENCENDER",
                    modifier = Modifier.fillMaxWidth(),
                    enabled = selected != null && !viewModel.isSendingCommand,
                    onClick = {
                        viewModel.executeRemoteIgnition(
                            action = if (state == IgnitionState.ON) "APAGAR" else "ENCENDER"
                        )
                    }
                )

                SmartBikeCard {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(viewModel.lastActionMessage, color = MaterialTheme.colorScheme.onSurface)
                        Text("Modo de conexión: remoto / cuenta actual", color = MaterialTheme.colorScheme.onSurface)
                        viewModel.errorMessage?.let {
                            Text(it, color = MaterialTheme.colorScheme.error)
                        }
                    }
                }
            }
        }
    }
}
