package com.smartbike.retrofit.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CommandCreateRequestDto(
    val action: String
)

data class CommandResponseDto(
    val id: Int,
    @SerializedName("vehicle_id") val vehicleId: String,
    val action: String,
    val status: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("executed_at") val executedAt: String? = null
)

