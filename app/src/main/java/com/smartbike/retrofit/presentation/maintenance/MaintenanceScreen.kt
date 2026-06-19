package com.smartbike.retrofit.presentation.maintenance

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.smartbike.retrofit.ui.components.AppBackground
import com.smartbike.retrofit.ui.components.BottomNavBar
import com.smartbike.retrofit.ui.components.ScreenBackground
import com.smartbike.retrofit.ui.components.SmartBikeButton
import com.smartbike.retrofit.ui.components.SmartBikeCard
import com.smartbike.retrofit.ui.theme.AccentCold
import com.smartbike.retrofit.ui.theme.MonoFont
import com.smartbike.retrofit.ui.theme.ProgressGradient

@androidx.compose.material3.ExperimentalMaterial3Api
@Composable
fun MaintenanceScreen(
    navController: NavHostController,
    viewModel: MaintenanceViewModel = viewModel()
) {
    val history = listOf("04/03/2026 - Cambio de aceite", "15/02/2026 - Revision llantas", "08/02/2026 - Chequeo bateria")
    val primaryColor = MaterialTheme.colorScheme.primary
    val trackColor = MaterialTheme.colorScheme.surfaceVariant

    AppBackground {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = { Text("Mantenimiento") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = MaterialTheme.colorScheme.onBackground
                    )
                )
            },
            bottomBar = { BottomNavBar(navController) }
        ) { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    SmartBikeCard(accent = true) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("Aceite del Motor", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(vertical = 12.dp)) {
                                Canvas(modifier = Modifier.size(170.dp)) {
                                    val stroke = 14.dp.toPx()
                                    drawArc(
                                        color = trackColor,
                                        startAngle = -90f,
                                        sweepAngle = 360f,
                                        useCenter = false,
                                        style = Stroke(width = stroke, cap = StrokeCap.Round)
                                    )
                                    drawArc(
                                        brush = ProgressGradient,
                                        startAngle = -90f,
                                        sweepAngle = 262f,
                                        useCenter = false,
                                        style = Stroke(width = stroke, cap = StrokeCap.Round)
                                    )
                                }
                                Text(
                                    "73%",
                                    color = MaterialTheme.colorScheme.primary,
                                    fontFamily = MonoFont,
                                    style = MaterialTheme.typography.headlineLarge,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Text("Cambio recomendado en ~850 km", color = MaterialTheme.colorScheme.onSurface)
                            SmartBikeButton(text = "Registrar cambio", modifier = Modifier.padding(top = 10.dp), onClick = {})
                        }
                    }
                }

                item {
                    SmartBikeCard(accent = true) {
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text("Llantas", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                            Text("Delantera: 60% vida util", color = MaterialTheme.colorScheme.onSurface)
                            LinearProgressIndicator(
                                progress = { 0.60f },
                                modifier = Modifier.fillMaxWidth().height(10.dp),
                                color = MaterialTheme.colorScheme.primary,
                                trackColor = MaterialTheme.colorScheme.surfaceVariant
                            )
                            Text("Trasera: 45% vida util", color = MaterialTheme.colorScheme.onSurface)
                            LinearProgressIndicator(
                                progress = { 0.45f },
                                modifier = Modifier.fillMaxWidth().height(10.dp),
                                color = MaterialTheme.colorScheme.secondary,
                                trackColor = MaterialTheme.colorScheme.surfaceVariant
                            )
                        }
                    }
                }

                item {
                    SmartBikeCard {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("Bateria", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                            Text("Voltaje actual: 12.6V", color = MaterialTheme.colorScheme.onSurface)
                            Text("Estado: Normal", color = AccentCold)
                            Text("El voltaje se mantiene en rango seguro", color = MaterialTheme.colorScheme.onSurface)
                        }
                    }
                }

                item { Text("Historial", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground) }
                items(history) { item ->
                    SmartBikeCard {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.History, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                            Text(item, color = MaterialTheme.colorScheme.onSurface, modifier = Modifier.padding(start = 8.dp))
                        }
                    }
                }
            }
        }
    }
}
