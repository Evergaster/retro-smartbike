@file:Suppress("unused")

package com.smartbike.retrofit.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartbike.retrofit.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class SettingsViewModel : ViewModel() {
	var isLoggingOut by mutableStateOf(false)
		private set

	var errorMessage by mutableStateOf<String?>(null)
		private set

	fun logout(onSuccess: () -> Unit) {
		viewModelScope.launch {
			isLoggingOut = true
			errorMessage = null
			AuthRepositoryImpl.logout()
			onSuccess()
			isLoggingOut = false
		}
	}
}

