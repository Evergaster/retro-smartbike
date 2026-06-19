package com.smartbike.retrofit.data.remote.api

import com.smartbike.retrofit.data.session.SessionManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "API_BASE_URL"

    private val authInterceptor = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            SessionManager.authToken?.takeIf { it.isNotBlank() }?.let { token ->
                requestBuilder.addHeader("Authorization", "Bearer $token")
            }
            chain.proceed(requestBuilder.build())
        }
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()

    val api: SmartBikeApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(authInterceptor)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SmartBikeApi::class.java)
    }
}

