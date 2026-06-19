@file:Suppress("unused")

package com.smartbike.retrofit.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartbike.retrofit.data.repository.VehicleRepositoryImpl
import com.smartbike.retrofit.domain.model.Vehicle
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
	val vehicles: List<Vehicle> get() = VehicleRepositoryImpl.vehicles

	init {
		refresh()
	}

	fun refresh() {
		viewModelScope.launch {
			VehicleRepositoryImpl.refreshVehicles()
		}
	}
}
