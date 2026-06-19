package com.smartbike.retrofit.data.local.entities

data class VehicleEntity(
    val id: String,
    val nickname: String,
    val vin: String,
    val totalKm: Double,
    val isNeutral: Boolean,
    val ownerId: String,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val batteryVoltage: Double? = null
)

