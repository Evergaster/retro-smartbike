package com.smartbike.retrofit.presentation.vehicles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsBike
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.smartbike.retrofit.data.session.SessionManager
import com.smartbike.retrofit.domain.model.Vehicle
import com.smartbike.retrofit.ui.components.AppBackground
import com.smartbike.retrofit.ui.components.InputField
import com.smartbike.retrofit.ui.components.SmartBikeButton

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("unused")
@Composable
fun VehicleCreateScreen(
    navController: NavHostController,
    viewModel: VehiclesViewModel = viewModel()
) {
    var nickname by remember { mutableStateOf("") }
    var vin by remember { mutableStateOf("") }
    var isNeutral by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    AppBackground {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = { Text("Agregar vehículo") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = MaterialTheme.colorScheme.onBackground
                    ),
                    navigationIcon = {
                        TextButton(onClick = { navController.popBackStack() }) {
                            Text("Cancelar")
                        }
                    }
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                        Icon(Icons.AutoMirrored.Filled.DirectionsBike, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    Column {
                        Text("Nuevo vehículo", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
                        Text("Completa los datos para mostrarlo en lista, mapa y encendido remoto.", color = MaterialTheme.colorScheme.onSurface)
                    }
                }

                Spacer(Modifier.height(4.dp))

                InputField(nickname, { nickname = it }, "Apodo / nombre")
                InputField(vin, { vin = it }, "VIN")

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Disponible para encendido", fontWeight = FontWeight.SemiBold)
                        Text("Solo los vehículos disponibles aparecerán en el selector remoto.", color = MaterialTheme.colorScheme.onSurface)
                    }
                    Switch(checked = isNeutral, onCheckedChange = { isNeutral = it })
                }

                errorMessage?.let {
                    Text(it, color = MaterialTheme.colorScheme.error)
                }

                Spacer(Modifier.height(8.dp))

                SmartBikeButton(
                    text = "GUARDAR VEHÍCULO",
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        errorMessage = when {
                            nickname.isBlank() -> "Escribe un nombre para el vehículo"
                            vin.isBlank() -> "Escribe el VIN"
                            else -> null
                        }

                        if (errorMessage == null) {
                            val userId = SessionManager.currentUser?.id
                            if (userId == null) {
                                // Si no hay usuario, solo mostramos el error y evitamos llamar a la API
                                errorMessage = "Debes iniciar sesión para agregar un vehículo"
                            } else {
                                viewModel.addVehicle(
                                    Vehicle(
                                        id = "vehicle-${System.currentTimeMillis()}",
                                        nickname = nickname.trim(),
                                        vin = vin.trim(),
                                        totalKm = 0.0,
                                        isNeutral = isNeutral,
                                        ownerId = userId
                                    ),
                                    onSuccess = { navController.popBackStack() },
                                    onError = { errorMessage = it }
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}
