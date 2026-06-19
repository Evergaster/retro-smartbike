package com.smartbike.retrofit.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TelemetryRequestDto(
    @SerializedName("vehicle_id") val vehicleId: String,
    val lat: Double,
    val lng: Double,
    @SerializedName("battery_v") val batteryV: Double,
    @SerializedName("speed_kmh") val speedKmh: Double
)

data class TelemetryResponseDto(
    val id: Int,
    @SerializedName("vehicle_id") val vehicleId: String,
    val lat: Double,
    val lng: Double,
    @SerializedName("battery_v") val batteryV: Double,
    @SerializedName("speed_kmh") val speedKmh: Double,
    @SerializedName("recorded_at") val recordedAt: String
)

