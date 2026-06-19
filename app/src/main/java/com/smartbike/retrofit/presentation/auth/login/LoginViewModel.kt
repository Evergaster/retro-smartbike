@file:Suppress("unused")

package com.smartbike.retrofit.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartbike.retrofit.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class LoginViewModel : ViewModel() {
	var isLoading by mutableStateOf(false)
		private set

	var errorMessage by mutableStateOf<String?>(null)
		private set

	fun login(email: String, password: String, onSuccess: () -> Unit) {
		viewModelScope.launch {
			isLoading = true
			errorMessage = null
			try {
				AuthRepositoryImpl.login(email, password)
				onSuccess()
			} catch (throwable: Throwable) {
				errorMessage = throwable.message ?: "No se pudo iniciar sesión"
			} finally {
				isLoading = false
			}
		}
	}
}

