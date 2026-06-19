package com.smartbike.retrofit.presentation.vehicle_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.GpsFixed
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.smartbike.retrofit.ui.components.AppBackground
import com.smartbike.retrofit.ui.components.BottomNavBar
import com.smartbike.retrofit.ui.components.IconBox
import com.smartbike.retrofit.ui.components.SmartBikeCard
import com.smartbike.retrofit.ui.theme.MonoFont
import com.smartbike.retrofit.ui.theme.ProgressGradient
import com.smartbike.retrofit.ui.theme.TextSecondary
import com.smartbike.retrofit.ui.theme.TitleFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VehicleDetailScreen(navController: NavHostController) {
    AppBackground {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Detalle del Vehículo",
                            fontFamily = TitleFont,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )
            },
            bottomBar = { BottomNavBar(navController) }
        ) { paddingValues ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {

                // Nombre del vehículo en la parte superior
                item {
                    Text(
                        "Rocketman 310",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontFamily = TitleFont,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 4.dp, top = 8.dp)
                    )
                }

                // Mapa pequeño
                item {
                    SmartBikeCard {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                        ) {
                            Text(
                                "📍 Ubicación en tiempo real",
                                color = TextSecondary,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }

                // Label de telemetría
                item {
                    Text(
                        "TELEMETRÍA",
                        color = TextSecondary,
                        fontSize = 11.sp,
                        letterSpacing = 1.5.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                // Grid de telemetría 2 columnas
                item {
                    val telemetryItems = listOf(
                        Triple(Icons.Default.Speed, "Velocidad", "0 km/h"),
                        Triple(Icons.Default.GpsFixed, "GPS", "Activo"),
                        Triple(Icons.Default.Security, "Alarma", "Armada"),
                        Triple(Icons.Default.AccessTime, "Último enc.", "Hace 2h")
                    )

                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        telemetryItems.chunked(2).forEach { rowItems ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                rowItems.forEach { (icon, label, value) ->
                                    TelemetryCard(
                                        icon = icon,
                                        label = label,
                                        value = value,
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                                if (rowItems.size == 1) Spacer(Modifier.weight(1f))
                            }
                        }
                    }
                }

                // Label de mantenimiento
                item {
                    Text(
                        "MANTENIMIENTO",
                        color = TextSecondary,
                        fontSize = 11.sp,
                        letterSpacing = 1.5.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                // Sección de mantenimiento
                item {
                    SmartBikeCard {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            MaintenanceProgressRow("Aceite", 0.73f)
                            MaintenanceProgressRow("Llantas", 0.55f)
                        }
                    }
                }

                item { Spacer(Modifier.height(8.dp)) }
            }
        }
    }
}

@Composable
fun TelemetryCard(icon: ImageVector, label: String, value: String, modifier: Modifier) {
    SmartBikeCard(modifier = modifier) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IconBox(icon)
            Text(
                value,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 22.sp,
                fontFamily = MonoFont,
                fontWeight = FontWeight.Bold
            )
            Text(label, color = MaterialTheme.colorScheme.onSurface, fontSize = 11.sp)
        }
    }
}

@Composable
fun MaintenanceProgressRow(label: String, progress: Float) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label, color = MaterialTheme.colorScheme.onSurface, fontSize = 13.sp)
            Text(
                "${(progress * 100).toInt()}%",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 13.sp,
                fontFamily = MonoFont
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(RoundedCornerShape(50))
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progress)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(50))
                    .background(ProgressGradient)
            )
        }
    }
}
