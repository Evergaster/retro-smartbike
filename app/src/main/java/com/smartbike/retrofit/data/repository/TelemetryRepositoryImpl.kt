package com.smartbike.retrofit.data.repository

import com.smartbike.retrofit.data.remote.api.ApiClient
import com.smartbike.retrofit.data.remote.dto.TelemetryRequestDto
import com.smartbike.retrofit.data.remote.dto.TelemetryResponseDto

object TelemetryRepositoryImpl {
    private val api = ApiClient.api

    suspend fun save(vehicleId: String, lat: Double, lng: Double, batteryV: Double, speedKmh: Double): TelemetryResponseDto {
        return api.saveTelemetry(
            TelemetryRequestDto(
                vehicleId = vehicleId,
                lat = lat,
                lng = lng,
                batteryV = batteryV,
                speedKmh = speedKmh
            )
        )
    }

    suspend fun latest(vehicleId: String): TelemetryResponseDto? {
        return try {
            api.getLatestTelemetry(vehicleId)
        } catch (_: Throwable) {
            null
        }
    }

    suspend fun history(vehicleId: String, limit: Int = 50): List<TelemetryResponseDto> {
        return api.getTelemetryHistory(vehicleId, limit)
    }
}

