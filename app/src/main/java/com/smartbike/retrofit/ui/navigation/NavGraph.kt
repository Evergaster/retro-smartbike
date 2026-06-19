package com.smartbike.retrofit.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.smartbike.retrofit.presentation.auth.login.LoginScreen
import com.smartbike.retrofit.presentation.auth.register.RegisterScreen
import com.smartbike.retrofit.presentation.auth.register.RegisterSuccessScreen
import com.smartbike.retrofit.presentation.home.HomeScreen
import com.smartbike.retrofit.presentation.ignition.IgnitionScreen
import com.smartbike.retrofit.presentation.maintenance.MaintenanceScreen
import com.smartbike.retrofit.presentation.settings.SettingsScreen
import com.smartbike.retrofit.presentation.trip_history.TripHistoryScreen
import com.smartbike.retrofit.presentation.vehicle_detail.VehicleDetailScreen
import com.smartbike.retrofit.presentation.vehicles.VehicleCreateScreen
import com.smartbike.retrofit.presentation.vehicles.VehiclesScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmartBikeNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.Register.route) {
            RegisterScreen(navController = navController)
        }
        composable(
            route = Screen.RegisterSuccess.route,
            arguments = listOf(navArgument("email") { type = NavType.StringType })
        ) { backStackEntry ->
            RegisterSuccessScreen(
                navController = navController,
                email = backStackEntry.arguments?.getString("email").orEmpty()
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Vehicles.route) {
            VehiclesScreen(navController = navController)
        }
        composable(Screen.VehicleCreate.route) {
            VehicleCreateScreen(navController = navController)
        }
        composable(Screen.VehicleDetail.route) {
            VehicleDetailScreen(navController = navController)
        }
        composable(Screen.Ignition.route) {
            IgnitionScreen(navController = navController)
        }
        composable(Screen.Maintenance.route) {
            MaintenanceScreen(navController = navController)
        }
        composable(Screen.TripHistory.route) {
            TripHistoryScreen(navController = navController)
        }
        composable(Screen.Settings.route) {
            SettingsScreen(navController = navController)
        }
    }
}

