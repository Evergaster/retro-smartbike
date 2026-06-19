package com.smartbike.retrofit.data.session

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.google.gson.Gson
import com.smartbike.retrofit.data.remote.dto.AuthUserDto

/**
 * SessionManager ahora persiste el token y el usuario en EncryptedSharedPreferences.
 * Llamar a [initialize] desde Application o MainActivity antes de realizar peticiones de red.
 */
object SessionManager {
    private const val PREFS_NAME = "smartbike_prefs"
    private const val KEY_AUTH_TOKEN = "auth_token"
    private const val KEY_AUTH_USER = "auth_user"

    private var prefs: SharedPreferences? = null
    private val gson = Gson()

    var authToken: String? by mutableStateOf(null)
        private set

    var currentUser: AuthUserDto? by mutableStateOf(null)
        private set

    fun initialize(context: Context) {
        if (prefs != null) return
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        val sp = EncryptedSharedPreferences.create(
            PREFS_NAME,
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        prefs = sp

        // Load existing session if any
        sp.getString(KEY_AUTH_TOKEN, null)?.let { token ->
            authToken = token
        }
        sp.getString(KEY_AUTH_USER, null)?.let { userJson ->
            try {
                currentUser = gson.fromJson(userJson, AuthUserDto::class.java)
            } catch (_: Exception) {
                currentUser = null
            }
        }
    }

    fun setSession(token: String, user: AuthUserDto) {
        authToken = token
        currentUser = user
        prefs?.edit()?.putString(KEY_AUTH_TOKEN, token)?.putString(KEY_AUTH_USER, gson.toJson(user))?.apply()
    }

    fun clear() {
        authToken = null
        currentUser = null
        prefs?.edit()?.clear()?.apply()
    }
}

