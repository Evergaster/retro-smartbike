package com.smartbike.retrofit.data.remote.dto

data class VehicleDto(
    val id: String,
    val nickname: String,
    val vin: String,
    val total_km: Double,
    val is_neutral: Boolean,
    val owner_id: String,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val battery_v: Double? = null
)

