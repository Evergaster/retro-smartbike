package com.smartbike.retrofit.data.repository

import com.smartbike.retrofit.data.remote.api.ApiClient
import com.smartbike.retrofit.data.remote.dto.CommandCreateRequestDto
import com.smartbike.retrofit.data.remote.dto.CommandResponseDto

object CommandRepositoryImpl {
    private val api = ApiClient.api

    suspend fun createCommand(vehicleId: String, action: String): CommandResponseDto {
        return api.createCommand(vehicleId, CommandCreateRequestDto(action = action))
    }

    suspend fun executeCommand(commandId: Int): CommandResponseDto {
        return api.executeCommand(commandId)
    }
}

