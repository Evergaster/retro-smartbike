package com.smartbike.retrofit.presentation.trip_history

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Route
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.smartbike.retrofit.ui.components.AppBackground
import com.smartbike.retrofit.ui.components.BottomNavBar
import com.smartbike.retrofit.ui.components.ScreenBackground
import com.smartbike.retrofit.ui.components.SmartBikeCard
import com.smartbike.retrofit.ui.theme.ButtonPrimaryGradient
import com.smartbike.retrofit.ui.theme.MonoFont
import com.smartbike.retrofit.ui.theme.TextSecondary
import androidx.lifecycle.viewmodel.compose.viewModel

data class TripUi(
    val start: String,
    val duration: String,
    val distance: String,
    val maxSpeed: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TripHistoryScreen(
    navController: NavHostController,
    viewModel: TripHistoryViewModel = viewModel()
) {
    val trips = listOf(
        TripUi("21 Mar 08:20", "25 min", "14.2 km", "78 km/h"),
        TripUi("20 Mar 18:10", "12 min", "5.8 km", "52 km/h")
    )
    val filters = listOf("Hoy", "Esta semana", "Este mes")
    var selectedFilter by remember { mutableStateOf(filters.first()) }

    AppBackground {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = { Text("Mis Rutas") },
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
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(filters) { filter ->
                            val active = selectedFilter == filter
                            Box(
                                modifier = Modifier
                                    .background(if (active) ButtonPrimaryGradient else Brush.linearGradient(listOf(MaterialTheme.colorScheme.surfaceVariant, MaterialTheme.colorScheme.surfaceVariant)), RoundedCornerShape(999.dp))
                                    .border(
                                        1.dp,
                                        if (active) Color.Transparent else MaterialTheme.colorScheme.outlineVariant,
                                        RoundedCornerShape(999.dp)
                                    )
                                    .clickable { selectedFilter = filter }
                                    .padding(horizontal = 14.dp, vertical = 8.dp)
                            ) {
                                Text(filter, color = if (active) Color.White else MaterialTheme.colorScheme.onSurface)
                            }
                        }
                    }
                }

                item {
                    SmartBikeCard {
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text("Resumen", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                            Text("Total km: 20.0", color = MaterialTheme.colorScheme.onSurface, fontFamily = MonoFont)
                            Text("Viajes: 2", color = MaterialTheme.colorScheme.onSurface)
                            Text("Tiempo total: 37 min", color = MaterialTheme.colorScheme.onSurface)
                        }
                    }
                }

                if (trips.isEmpty()) {
                    item { Text("No hay rutas registradas en este periodo", color = MaterialTheme.colorScheme.onSurface) }
                } else {
                    items(trips) { trip ->
                        SmartBikeCard {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(42.dp)
                                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f), RoundedCornerShape(12.dp)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(Icons.Default.Route, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                }
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 10.dp),
                                    verticalArrangement = Arrangement.spacedBy(2.dp)
                                ) {
                                    Text(trip.start, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
                                    Text("Duracion: ${trip.duration}", color = MaterialTheme.colorScheme.onSurface)
                                    Text("Distancia: ${trip.distance}", color = MaterialTheme.colorScheme.primary, fontFamily = MonoFont)
                                    Text("Velocidad maxima: ${trip.maxSpeed}", color = TextSecondary)
                                }
                                Icon(Icons.Default.Map, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                            }
                        }
                    }
                }
            }
        }
    }
}
