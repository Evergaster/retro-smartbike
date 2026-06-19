# SmartBike — Documentación del Proyecto

## ¿Qué es SmartBike?

**SmartBike** es una aplicación Android nativa para la gestión inteligente de motocicletas y vehículos. Permite a los usuarios monitorear, controlar y dar mantenimiento a sus vehículos desde su teléfono, combinando telemetría en tiempo real, control remoto de encendido, geolocalización en mapa, historial de rutas y alertas de mantenimiento en una sola plataforma.

Desarrollada con **Kotlin**, **Jetpack Compose** y arquitectura **Clean Architecture + MVVM**, está diseñada para escalar, mantenerse y ofrecer una experiencia de usuario moderna y fluida.

---

## Funcionalidades principales

| Módulo | Descripción |
|---|---|
| **Autenticación** | Registro, inicio de sesión y cierre de sesión con manejo de sesiones |
| **Gestión de vehículos** | CRUD completo: crear, listar, ver detalle, editar y eliminar vehículos |
| **Mapa en tiempo real** | Visualización de ubicación de vehículos en mapa OpenStreetMap (osmdroid) con marcadores personalizados |
| **Encendido remoto** | Control de encendido/apagado remoto con selector de vehículo y detección de estado neutral |
| **Telemetría** | Consulta de velocidad, estado GPS, alarma, voltaje de batería y última actividad |
| **Historial de rutas** | Registro de viajes con distancia, duración, velocidad máxima y filtros por período |
| **Mantenimiento predictivo** | Monitoreo de vida útil de aceite, desgaste de llantas, voltaje de batería e historial de servicios |
| **Ajustes** | Perfil de usuario, preferencias de notificaciones, configuración de vehículo y cierre de sesión |

---

## Arquitectura

SmartBike sigue los principios de **Clean Architecture** con tres capas bien definidas:

```
📦 com.smartbike.retrofit
├── data/           # Capa de datos
│   ├── remote/     # API REST (Retrofit), DTOs, WebSocket
│   ├── local/      # Room Database, DAOs, entidades locales
│   ├── repository/ # Implementaciones de repositorios
│   └── session/    # Manejo de sesión de usuario
├── domain/         # Capa de dominio
│   ├── model/      # Modelos de negocio (Vehicle, TripRecord, MaintenanceAlert)
│   ├── repository/ # Interfaces de repositorio
│   └── usecase/    # Casos de uso (ToggleIgnitionUseCase, GetVehiclesUseCase)
├── presentation/   # Capa de presentación
│   ├── auth/       # Login, registro
│   ├── home/       # Mapa principal
│   ├── vehicles/   # Lista y creación de vehículos
│   ├── vehicle_detail/
│   ├── ignition/   # Control remoto de encendido
│   ├── trip_history/
│   ├── maintenance/
│   └── settings/
├── ui/             # Componentes Compose reutilizables, tema, navegación
└── di/             # Módulos de inyección de dependencias
```

### Tecnologías clave

- **Kotlin** — Lenguaje principal
- **Jetpack Compose** — UI declarativa moderna
- **Material 3** — Sistema de diseño con tema oscuro personalizado
- **Retrofit** — Cliente HTTP para API REST
- **Room** — Almacenamiento local offline
- **osmdroid** — Mapas OpenStreetMap sin dependencia de Google Play
- **WebSocket** — Telemetría en tiempo real
- **MVVM + ViewModel** — Separación de responsabilidades
- **Coroutines** — Concurrencia asíncrona
- **Hilt / Koin** — Inyección de dependencias

---

## ¿Por qué SmartBike es mejor que otras opciones?

### 1. Sin dependencia de Google Play Services

A diferencia de muchas apps que requieren Google Maps y Google Play Services, SmartBike usa **osmdroid** (OpenStreetMap). Esto permite:
- Funcionar en dispositivos sin Google Play (Huawei, Kindle, custom ROMs)
- Menor consumo de batería y datos
- Sin restricciones de licencia ni límites de uso de API

### 2. Arquitectura limpia y mantenible

Mientras muchas apps del mercado son difíciles de mantener por falta de estructura, SmartBike implementa **Clean Architecture + MVVM** desde el día uno, lo que se traduce en:
- Código desacoplado y testeable
- Separación clara entre UI, lógica de negocio y datos
- Fácil de extender con nuevas funcionalidades
- Bajo costo de incorporación de nuevos desarrolladores

### 3. Control remoto de encendido

SmartBike incluye un módulo de **encendido remoto** con:
- Selector de vehículo con detección de estado neutral
- Animaciones de estado en tiempo real
- Comunicación vía API REST con confirmación de comando

### 4. Mantenimiento predictivo integrado

A diferencia de soluciones genéricas, SmartBike ofrece:
- Monitoreo de vida útil de aceite con representación visual tipo circular
- Seguimiento de desgaste de llantas delantera y trasera
- Voltaje de batería con indicación de estado
- Historial de servicios con fechas

### 5. Experiencia de usuario moderna con Material 3

- Tema oscuro personalizado con degradados y animaciones suaves
- Componentes reutilizables (SmartBikeCard, SmartBikeButton, InputField, etc.)
- Navegación intuitiva con barra inferior y FAB central
- Tipografía monoespaciada para datos técnicos

### 6. Preparada para producción

- Inyección de dependencias modularizada
- Manejo de sesiones con persistencia
- Caché local con Room para funcionamiento offline parcial
- WebSocket preparado para telemetría en tiempo real
- Separación de entidades de dominio, DTOs de API y entidades de base de datos

---

## Pantallas de la aplicación

| Pantalla | Ruta | Descripción |
|---|---|---|
| Login | `login` | Inicio de sesión con credenciales |
| Registro | `register` | Creación de cuenta nueva |
| Registro exitoso | `register_success/{email}` | Confirmación de registro |
| Inicio (Mapa) | `home` | Mapa con ubicación de vehículos |
| Mis vehículos | `vehicles` | Lista de vehículos registrados |
| Crear vehículo | `vehicle_create` | Formulario para agregar vehículo |
| Detalle vehículo | `vehicle_detail` | Telemetría y mantenimiento por vehículo |
| Encendido remoto | `ignition` | Control remoto de encendido |
| Historial de rutas | `trip_history` | Viajes registrados con filtros |
| Mantenimiento | `maintenance` | Estado de aceite, llantas, batería |
| Ajustes | `settings` | Perfil, notificaciones, cerrar sesión |

---

## Estado del proyecto

SmartBike se encuentra en fase de desarrollo activo con la UI completamente implementada y la integración con backend REST en proceso. Está construida pensando en escalabilidad, buenas prácticas de código y experiencia de usuario.
