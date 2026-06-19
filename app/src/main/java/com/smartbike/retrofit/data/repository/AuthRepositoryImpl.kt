package com.smartbike.retrofit.data.repository

import com.smartbike.retrofit.data.remote.api.ApiClient
import com.smartbike.retrofit.data.remote.dto.AuthResponseDto
import com.smartbike.retrofit.data.remote.dto.LoginRequestDto
import com.smartbike.retrofit.data.remote.dto.RegisterRequestDto
import com.smartbike.retrofit.data.session.SessionManager

object AuthRepositoryImpl {
    private val api = ApiClient.api

    suspend fun login(email: String, password: String): AuthResponseDto {
        val response = api.login(LoginRequestDto(email = email, password = password))
        SessionManager.setSession(response.accessToken, response.user)
        return response
    }

    suspend fun register(fullName: String, email: String, password: String): AuthResponseDto {
        val response = api.register(
            RegisterRequestDto(
                email = email,
                password = password,
                fullName = fullName
            )
        )
        SessionManager.setSession(response.accessToken, response.user)
        return response
    }

    suspend fun logout() {
        SessionManager.clear()
        try {
            api.logout()
        } catch (_: Throwable) {
            // Only local session clearing matters
        }
    }
}

