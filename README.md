# RetroMoto — Smart-Bike

[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.10-purple?logo=kotlin)](https://kotlinlang.org)
[![Android](https://img.shields.io/badge/Android-14+-green?logo=android)](https://developer.android.com)
[![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose-4285F4?logo=jetpackcompose)](https://developer.android.com/jetpack/compose)
[![Retrofit](https://img.shields.io/badge/Retrofit-2.11.0-48B983?logo=square)](https://square.github.io/retrofit/)
[![Supabase](https://img.shields.io/badge/Supabase-Database-3ECF8E?logo=supabase)](https://supabase.com)
[![ESP32](https://img.shields.io/badge/Hardware-ESP32-E7352C?logo=espressif)](https://www.espressif.com)

Aplicación Android para la gestión inteligente de motocicletas. Se conecta a una API REST para proporcionar telemetría en tiempo real, control remoto de encendido, rastreo GPS mediante un dispositivo IoT basado en ESP32 y monitoreo de mantenimiento predictivo.

## Características

- **Autenticación** — Registro, inicio de sesión y gestión de sesiones con almacenamiento de tokens cifrados
- **Gestión de vehículos** — CRUD completo para registrar y administrar motocicletas
- **GPS en vivo** — Ubicación del vehículo en OpenStreetMap vía ESP32 + módem celular
- **Encendido remoto** — Prender/apagar el motor con detección de punto neutro
- **Panel de telemetría** — Velocidad, estado GPS, voltaje de batería, estado de alarma y última actividad
- **Historial de rutas** — Registros de viajes con distancia, duración, velocidad máxima y filtros por fecha
- **Mantenimiento predictivo** — Vida útil del aceite, desgaste de llantas, salud de batería e historial de servicios
- **Soporte offline** — Base de datos Room para caché local y funcionalidad parcial sin conexión

## Stack Tecnológico

| Capa | Tecnología |
|---|---|
| **Lenguaje** | Kotlin |
| **UI** | Jetpack Compose + Material 3 (tema oscuro) |
| **Arquitectura** | Clean Architecture + MVVM + Repository pattern |
| **Red** | Retrofit 2 + OkHttp + Gson |
| **Base de datos** | Room (local), Supabase (servidor) |
| **Auth** | EncryptedSharedPreferences (AES-256) |
| **Mapas** | osmdroid (OpenStreetMap, sin dependencia de Google Play) |
| **IoT** | ESP32 + Módem celular |
| **Async** | Kotlin Coroutines |
| **DI** | Manual / Hilt (modularizado) |

## Arquitectura

```
com.smartbike.retrofit
├── data/               # API Remota (Retrofit), Room DB, DTOs, repositorios
├── domain/             # Modelos de negocio, interfaces de repositorio, casos de uso
├── presentation/       # ViewModels + pantallas Compose (auth, home, vehicles, etc.)
├── ui/                 # Componentes Compose reutilizables, navegación, tema
├── di/                 # Módulos de inyección de dependencias
└── utils/              # Utilidades
```

Componentes clave:

- **SessionManager** — Singleton que persiste tokens de autenticación de forma segura usando `EncryptedSharedPreferences` y expone estado reactivo via `mutableStateOf` de Compose
- **ApiClient** — Instancia de Retrofit con un interceptor que adjunta automáticamente el token Bearer desde `SessionManager`
- **SmartBikeApi** — Interfaz Retrofit que define todos los endpoints REST (auth, vehículos, telemetría, comandos)

## Hardware — Dispositivo IoT ESP32

El vehículo está equipado con un microcontrolador ESP32 conectado a un módem celular. Este:

- Lee coordenadas GPS, velocidad, voltaje de batería y estado de alarma del vehículo
- Envía datos de telemetría a la API REST en intervalos regulares
- Recibe comandos remotos de encendido/apagado desde el servidor

## Configuración

1. **Clonar el repositorio**

```bash
git clone https://github.com/your-username/retromoto.git
cd retromoto
```

2. **Definir la URL base de la API**

Abrir `app/src/main/java/com/smartbike/retrofit/data/remote/api/ApiClient.kt` y reemplazar el placeholder `BASE_URL`:

```kotlin
private const val BASE_URL = "https://tu-backend.vercel.app/"
```

3. **Compilar con Gradle**

```bash
./gradlew :app:assembleDebug
```

4. **Ejecutar en dispositivo**

Abrir el proyecto en Android Studio y ejecutar el módulo `app` en un emulador o dispositivo físico (API 27+).

## Licencia

```
MIT License

Copyright (c) 2025 RetroMoto

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
