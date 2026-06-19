package com.smartbike.retrofit.data.remote.dto

import com.google.gson.annotations.SerializedName

data class VehicleCreateRequestDto(
    val nickname: String,
    val vin: String,
    @SerializedName("total_km") val totalKm: Double,
    @SerializedName("is_neutral") val isNeutral: Boolean
)

data class VehicleUpdateRequestDto(
    val nickname: String? = null,
    val vin: String? = null,
    @SerializedName("total_km") val totalKm: Double? = null,
    @SerializedName("is_neutral") val isNeutral: Boolean? = null
)

data class VehicleResponseDto(
    val id: String,
    val nickname: String,
    val vin: String,
    @SerializedName("total_km") val totalKm: Double,
    @SerializedName("is_neutral") val isNeutral: Boolean,
    @SerializedName("owner_id") val ownerId: String,
    @SerializedName("created_at") val createdAt: String
)

