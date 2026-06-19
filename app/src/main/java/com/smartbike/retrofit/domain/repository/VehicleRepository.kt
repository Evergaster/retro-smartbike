@file:Suppress("unused")

package com.smartbike.retrofit.domain.repository

import com.smartbike.retrofit.domain.model.Vehicle

interface VehicleRepository {
    fun getVehicles(): List<Vehicle>
    fun addVehicle(vehicle: Vehicle)
}

