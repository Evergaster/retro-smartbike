package com.smartbike.retrofit.domain.usecase

import com.smartbike.retrofit.domain.model.Vehicle
import com.smartbike.retrofit.domain.repository.VehicleRepository

class GetVehiclesUseCase(
    private val repository: VehicleRepository
) {
    operator fun invoke(): List<Vehicle> = repository.getVehicles()
}

