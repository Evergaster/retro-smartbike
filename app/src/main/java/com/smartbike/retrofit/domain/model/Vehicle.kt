package com.smartbike.retrofit.domain.model

data class Vehicle(
    val id: String,
    val nickname: String,
    val vin: String,
    val totalKm: Double,
    val isNeutral: Boolean,
    val ownerId: String,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val batteryVoltage: Double? = null,
    val isAvailable: Boolean = isNeutral
)

