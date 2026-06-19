@file:Suppress("unused")

package com.smartbike.retrofit.presentation.vehicles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartbike.retrofit.data.repository.VehicleRepositoryImpl
import com.smartbike.retrofit.domain.model.Vehicle
import kotlinx.coroutines.launch

class VehiclesViewModel : ViewModel() {
	val vehicles: List<Vehicle> get() = VehicleRepositoryImpl.vehicles

	init {
		refresh()
	}

	fun refresh() {
		viewModelScope.launch {
			VehicleRepositoryImpl.refreshVehicles()
		}
	}

	fun addVehicle(vehicle: Vehicle, onSuccess: () -> Unit = {}, onError: (String) -> Unit = {}) {
		viewModelScope.launch {
			try {
				VehicleRepositoryImpl.createVehicle(vehicle)
				onSuccess()
			} catch (throwable: Throwable) {
				val msg = if (throwable is retrofit2.HttpException) {
					try {
						val body = throwable.response()?.errorBody()?.string()
						val json = com.google.gson.JsonParser.parseString(body).asJsonObject
						json.get("detail")?.asString ?: throwable.message
					} catch (_: Exception) {
						throwable.message
					}
				} else {
					throwable.message
				}
				onError(msg ?: "No se pudo crear el vehículo")
			}
		}
	}
}

