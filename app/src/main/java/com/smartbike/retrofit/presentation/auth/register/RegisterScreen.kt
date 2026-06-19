package com.smartbike.retrofit.presentation.auth.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.smartbike.retrofit.ui.components.InputField
import com.smartbike.retrofit.ui.components.ScreenBackground
import com.smartbike.retrofit.ui.components.SmartBikeButton
import com.smartbike.retrofit.ui.navigation.Screen

@Composable
fun RegisterScreen(
    navController: NavHostController,
    viewModel: RegisterViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    ScreenBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Registro de Usuario", style = MaterialTheme.typography.headlineMedium)
            Text("Crea tu cuenta de Smart-Bike", color = MaterialTheme.colorScheme.onSurface)
            Spacer(Modifier.height(24.dp))

            InputField(name, { name = it }, "Nombre Completo", leadingIcon = { Icon(Icons.Default.Person, null) }, isFocused = name.isNotBlank())
            Spacer(Modifier.height(12.dp))
            InputField(email, { email = it }, "Correo Electronico", leadingIcon = { Icon(Icons.Default.Email, null) }, isFocused = email.isNotBlank())
            Spacer(Modifier.height(12.dp))
            InputField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Contrasena",
                leadingIcon = { Icon(Icons.Default.VisibilityOff, null) },
                trailingIcon = {
                    IconButton(onClick = { showPassword = !showPassword }) {
                        Icon(if (showPassword) Icons.Default.VisibilityOff else Icons.Default.Visibility, null)
                    }
                },
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                isFocused = password.isNotBlank()
            )
            Spacer(Modifier.height(12.dp))
            InputField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                placeholder = "Confirmar Contrasena",
                leadingIcon = { Icon(Icons.Default.Lock, null) },
                trailingIcon = {
                    IconButton(onClick = { showConfirmPassword = !showConfirmPassword }) {
                        Icon(if (showConfirmPassword) Icons.Default.VisibilityOff else Icons.Default.Visibility, null)
                    }
                },
                visualTransformation = if (showConfirmPassword) VisualTransformation.None else PasswordVisualTransformation(),
                isFocused = confirmPassword.isNotBlank()
            )
            Spacer(Modifier.height(18.dp))
            SmartBikeButton(if (viewModel.isLoading) "CREANDO..." else "CREAR CUENTA") {
                errorMessage = when {
                    name.isBlank() -> "Ingresa tu nombre completo"
                    email.isBlank() || !email.contains("@") -> "Ingresa un correo válido"
                    password.length < 6 -> "La contraseña debe tener al menos 6 caracteres"
                    password != confirmPassword -> "Las contraseñas no coinciden"
                    else -> null
                }

                if (errorMessage == null) {
                    viewModel.register(name.trim(), email.trim(), password) { confirmedEmail ->
                        navController.navigate(Screen.RegisterSuccess.createRoute(confirmedEmail)) {
                            popUpTo(Screen.Register.route) { inclusive = true }
                        }
                    }
                }
            }
            viewModel.errorMessage?.let {
                Spacer(Modifier.height(10.dp))
                Text(it, color = MaterialTheme.colorScheme.error)
            }
            errorMessage?.let {
                Spacer(Modifier.height(10.dp))
                Text(it, color = MaterialTheme.colorScheme.error)
            }
            Spacer(Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                HorizontalDivider(Modifier.weight(1f), color = MaterialTheme.colorScheme.outlineVariant)
                Text("  o  ", color = MaterialTheme.colorScheme.onSurface)
                HorizontalDivider(Modifier.weight(1f), color = MaterialTheme.colorScheme.outlineVariant)
            }
            Spacer(Modifier.height(18.dp))
            Row {
                Text("Ya tienes cuenta? ", color = MaterialTheme.colorScheme.onSurface)
                Text(
                    text = "Iniciar sesion",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(start = 2.dp)
                        .clickable { navController.navigate(Screen.Login.route) }
                )
            }
        }
    }
}
