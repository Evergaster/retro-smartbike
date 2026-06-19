package com.smartbike.retrofit.presentation.ignition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.smartbike.retrofit.data.repository.CommandRepositoryImpl
import com.smartbike.retrofit.data.repository.VehicleRepositoryImpl
import com.smartbike.retrofit.domain.model.Vehicle
import kotlinx.coroutines.launch

class IgnitionViewModel : ViewModel() {
    val vehicles: List<Vehicle> get() = VehicleRepositoryImpl.vehicles

    var selectedVehicleId: String? by mutableStateOf(null)
        private set

    var selectedVehicle: Vehicle? by mutableStateOf(null)
        private set

    var lastActionMessage: String by mutableStateOf("Selecciona un vehículo para encender")
        private set

    var isSendingCommand by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun selectVehicle(vehicleId: String?) {
        selectedVehicleId = vehicleId
        selectedVehicle = vehicles.firstOrNull { it.id == vehicleId }
        lastActionMessage = selectedVehicle?.let {
            if (it.isNeutral) "Listo para encender ${it.nickname}"
            else "${it.nickname} ya está encendido"
        } ?: "Selecciona un vehículo para encender"
    }

    fun executeRemoteIgnition(action: String = "ENCENDER") {
        viewModelScope.launch {
            isSendingCommand = true
            errorMessage = null
            try {
                val target = selectedVehicleId?.let { id ->
                    vehicles.firstOrNull { it.id == id }
                }

                if (target == null) {
                    lastActionMessage = "No hay vehículo seleccionado"
                    return@launch
                }

                CommandRepositoryImpl.createCommand(target.id, action)

                // Actualizar isNeutral localmente
                val index = VehicleRepositoryImpl.vehicles.indexOfFirst { it.id == target.id }
                if (index != -1) {
                    val updated = target.copy(isNeutral = action == "APAGAR")
                    VehicleRepositoryImpl.vehicles[index] = updated
                    selectedVehicle = updated
                }

                lastActionMessage = "${if (action == "ENCENDER") "Encendido" else "Apagado"} remoto enviado a ${target.nickname}"
            } catch (throwable: Throwable) {
                errorMessage = throwable.message ?: "No se pudo enviar el comando"
                lastActionMessage = errorMessage.orEmpty()
            } finally {
                isSendingCommand = false
            }
        }
    }
}
