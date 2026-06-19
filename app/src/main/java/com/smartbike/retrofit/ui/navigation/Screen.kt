@file:Suppress("unused")

package com.smartbike.retrofit.ui.navigation

import android.net.Uri

sealed class Screen(val route: String) {
    data object Login : Screen("login")
    data object Register : Screen("register")
    data object RegisterSuccess : Screen("register_success/{email}") {
        fun createRoute(email: String) = "register_success/${Uri.encode(email)}"
    }
    data object Home : Screen("home")
    data object Vehicles : Screen("vehicles")
    data object VehicleCreate : Screen("vehicle_create")
    data object VehicleDetail : Screen("vehicle_detail")
    data object Ignition : Screen("ignition")
    data object Maintenance : Screen("maintenance")
    data object TripHistory : Screen("trip_history")
    data object Settings : Screen("settings")
}

