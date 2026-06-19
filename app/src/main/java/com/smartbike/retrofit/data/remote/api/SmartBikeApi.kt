package com.smartbike.retrofit.data.remote.api

import com.smartbike.retrofit.data.remote.dto.AuthResponseDto
import com.smartbike.retrofit.data.remote.dto.CommandCreateRequestDto
import com.smartbike.retrofit.data.remote.dto.CommandResponseDto
import com.smartbike.retrofit.data.remote.dto.LoginRequestDto
import com.smartbike.retrofit.data.remote.dto.MessageResponseDto
import com.smartbike.retrofit.data.remote.dto.RegisterRequestDto
import com.smartbike.retrofit.data.remote.dto.TelemetryRequestDto
import com.smartbike.retrofit.data.remote.dto.TelemetryResponseDto
import com.smartbike.retrofit.data.remote.dto.VehicleCreateRequestDto
import com.smartbike.retrofit.data.remote.dto.VehicleResponseDto
import com.smartbike.retrofit.data.remote.dto.VehicleUpdateRequestDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface SmartBikeApi {
	@POST("api/v1/auth/register")
	suspend fun register(@Body request: RegisterRequestDto): AuthResponseDto

	@POST("api/v1/auth/login")
	suspend fun login(@Body request: LoginRequestDto): AuthResponseDto

	@POST("api/v1/auth/logout")
	suspend fun logout(): MessageResponseDto

	@GET("api/v1/auth/me")
	suspend fun me(): MessageResponseDto

	@GET("api/v1/vehicles")
	suspend fun listVehicles(): List<VehicleResponseDto>

	@POST("api/v1/vehicles")
	suspend fun createVehicle(@Body request: VehicleCreateRequestDto): VehicleResponseDto

	@GET("api/v1/vehicles/{vehicle_id}")
	suspend fun getVehicle(@Path("vehicle_id") vehicleId: String): VehicleResponseDto

	@PUT("api/v1/vehicles/{vehicle_id}")
	suspend fun updateVehicle(
		@Path("vehicle_id") vehicleId: String,
		@Body request: VehicleUpdateRequestDto
	): VehicleResponseDto

	@DELETE("api/v1/vehicles/{vehicle_id}")
	suspend fun deleteVehicle(@Path("vehicle_id") vehicleId: String): MessageResponseDto

	@POST("api/v1/telemetry/save")
	suspend fun saveTelemetry(@Body request: TelemetryRequestDto): TelemetryResponseDto

	@GET("api/v1/telemetry/vehicle/{vehicle_id}/latest")
	suspend fun getLatestTelemetry(@Path("vehicle_id") vehicleId: String): TelemetryResponseDto

	@GET("api/v1/telemetry/vehicle/{vehicle_id}")
	suspend fun getTelemetryHistory(
		@Path("vehicle_id") vehicleId: String,
		@Query("limit") limit: Int = 50
	): List<TelemetryResponseDto>

	@POST("api/v1/vehicles/{vehicle_id}/commands")
	suspend fun createCommand(
		@Path("vehicle_id") vehicleId: String,
		@Body request: CommandCreateRequestDto
	): CommandResponseDto

	@GET("api/v1/vehicles/{vehicle_id}/commands")
	suspend fun listCommands(
		@Path("vehicle_id") vehicleId: String,
		@Query("status") status: String? = null
	): List<CommandResponseDto>

	@PUT("api/v1/commands/{command_id}/execute")
	suspend fun executeCommand(@Path("command_id") commandId: Int): CommandResponseDto
}

