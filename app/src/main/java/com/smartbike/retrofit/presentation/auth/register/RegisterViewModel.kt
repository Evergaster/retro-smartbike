@file:Suppress("unused")

package com.smartbike.retrofit.presentation.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartbike.retrofit.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class RegisterViewModel : ViewModel() {
	var isLoading by mutableStateOf(false)
		private set

	var errorMessage by mutableStateOf<String?>(null)
		private set

	fun register(fullName: String, email: String, password: String, onSuccess: (String) -> Unit) {
		viewModelScope.launch {
			isLoading = true
			errorMessage = null
			try {
				AuthRepositoryImpl.register(fullName = fullName, email = email, password = password)
				onSuccess(email)
			} catch (throwable: Throwable) {
				errorMessage = throwable.message ?: "No se pudo crear la cuenta"
			} finally {
				isLoading = false
			}
		}
	}
}

