package com.smartbike.retrofit.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginRequestDto(
    val email: String,
    val password: String
)

data class RegisterRequestDto(
    val email: String,
    val password: String,
    @SerializedName("full_name") val fullName: String
)

data class AuthUserDto(
    val id: String,
    val email: String,
    @SerializedName("full_name") val fullName: String? = null,
    val username: String? = null
)

data class AuthResponseDto(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("token_type") val tokenType: String,
    val user: AuthUserDto
)

data class MessageResponseDto(
    val message: String,
    val code: String? = null
)

data class ConfirmEmailRequestDto(
    @SerializedName("user_id") val userId: String
)

