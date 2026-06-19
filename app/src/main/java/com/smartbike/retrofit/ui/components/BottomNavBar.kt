package com.smartbike.retrofit.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsBike
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Power
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.smartbike.retrofit.ui.navigation.Screen
import com.smartbike.retrofit.ui.theme.AccentCold
import com.smartbike.retrofit.ui.theme.AccentWarm
import com.smartbike.retrofit.ui.theme.BackgroundDeep
import com.smartbike.retrofit.ui.theme.FabGradient
import com.smartbike.retrofit.ui.theme.TextSecondary

@Composable
fun BottomNavBar(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        // Barra de fondo
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .align(Alignment.BottomCenter)
                .background(BackgroundDeep)
                .drawWithContent {
                    drawContent()
                    drawLine(
                        brush = Brush.horizontalGradient(
                            listOf(
                                AccentWarm.copy(alpha = 0f),
                                AccentWarm.copy(alpha = 0.5f),
                                AccentWarm.copy(alpha = 0f)
                            )
                        ),
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = 1.5.dp.toPx()
                    )
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // Ítem Inicio
            NavItem(
                icon = Icons.Default.Home,
                label = "Inicio",
                selected = currentRoute == Screen.Home.route,
                onClick = { navController.navigate(Screen.Home.route) }
            )
            // Ítem Vehículos
            NavItem(
                icon = Icons.AutoMirrored.Filled.DirectionsBike,
                label = "Vehículos",
                selected = currentRoute == Screen.Vehicles.route,
                onClick = { navController.navigate(Screen.Vehicles.route) }
            )
            // Espacio para el FAB central
            Spacer(Modifier.width(64.dp))
            // Ítem Encendido
            NavItem(
                icon = Icons.Default.Power,
                label = "Encendido",
                selected = currentRoute == Screen.Ignition.route,
                onClick = { navController.navigate(Screen.Ignition.route) }
            )
            // Ítem Ajustes
            NavItem(
                icon = Icons.Default.Settings,
                label = "Ajustes",
                selected = currentRoute == Screen.Settings.route,
                onClick = { navController.navigate(Screen.Settings.route) }
            )
        }

        // FAB central — elevado con offset negativo
        Box(
            modifier = Modifier
                .size(56.dp)
                .align(Alignment.TopCenter)
                .offset(y = (-12).dp)
                .clip(CircleShape)
                .background(FabGradient)
                .border(1.5.dp, Color(0x30FFFFFF), CircleShape)
                .clickable { navController.navigate(Screen.Ignition.route) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.PowerSettingsNew,
                contentDescription = "Encendido",
                tint = Color.White,
                modifier = Modifier.size(26.dp)
            )
        }
    }
}

@Composable
fun NavItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val color = if (selected) AccentCold else TextSecondary

    Column(
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,  // sin ripple feo
                onClick = onClick
            )
            .padding(horizontal = 8.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Icon(icon, contentDescription = label,
            tint = color, modifier = Modifier.size(22.dp))
        Text(label, color = color, fontSize = 10.sp,
            letterSpacing = 0.3.sp)
    }
}
