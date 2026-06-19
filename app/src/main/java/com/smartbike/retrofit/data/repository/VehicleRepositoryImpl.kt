@file:Suppress("unused")

package com.smartbike.retrofit.data.repository

import androidx.compose.runtime.mutableStateListOf
import com.smartbike.retrofit.data.remote.api.ApiClient
import com.smartbike.retrofit.data.remote.dto.VehicleCreateRequestDto
import com.smartbike.retrofit.data.remote.dto.VehicleResponseDto
import com.smartbike.retrofit.data.session.SessionManager
import com.smartbike.retrofit.domain.model.Vehicle
import com.smartbike.retrofit.domain.repository.VehicleRepository

object VehicleRepositoryImpl : VehicleRepository {

    private val api = ApiClient.api
    val vehicles = mutableStateListOf<Vehicle>()

    override fun getVehicles(): List<Vehicle> = vehicles.toList()

    override fun addVehicle(vehicle: Vehicle) {
        vehicles.add(vehicle)
    }

    suspend fun refreshVehicles(): List<Vehicle> {
        val ownerId = SessionManager.currentUser?.id
        if (ownerId == null) {
            vehicles.clear()
            return emptyList()
        }

        val remoteVehicles = api.listVehicles().filter { it.ownerId == ownerId }
        val enriched = remoteVehicles.map { it.toDomainVehicle() }



        vehicles.clear()
        vehicles.addAll(enriched)
        return enriched
    }

    suspend fun createVehicle(vehicle: Vehicle): VehicleResponseDto {
        val created = api.createVehicle(
            VehicleCreateRequestDto(
                nickname = vehicle.nickname,
                vin = vehicle.vin,
                totalKm = vehicle.totalKm,
                isNeutral = vehicle.isNeutral
            )
        )
        refreshVehicles()
        return created
    }

    private suspend fun VehicleResponseDto.toDomainVehicle(): Vehicle {
        val latestTelemetry = TelemetryRepositoryImpl.latest(id)
        return Vehicle(
            id = id,
            nickname = nickname,
            vin = vin,
            totalKm = totalKm,
            isNeutral = isNeutral,
            ownerId = ownerId,
            latitude = latestTelemetry?.lat,
            longitude = latestTelemetry?.lng,
            batteryVoltage = latestTelemetry?.batteryV,
            isAvailable = isNeutral
        )
    }
}

