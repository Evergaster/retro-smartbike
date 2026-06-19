

Retrofit Smart-Bike API
## /openapi.json
API para sistema IoT de motocicletas
## Authorize
## Auth
## POST
## POST
/api/v1/auth/registerRegister
Registra una nueva cuenta en Supabase Auth.
Request: { "email": "rider@email.com", "password": "moto123", "full_name": "Juan Pérez" }
Response: { "access_token": "eyJ...", "token_type": "bearer", "user": { "id": "uuid", "email":
"rider@email.com", "full_name": "Juan Pérez" } }
Try it out
No parameters
Request bodyapplication/json
## Schema
## Responses
## 1.0.0 OAS 3.1
## Parameters
required
## Example Value
## {
## "email": "user@example.com",
## "password": "string",
## "full_name": "string"
## }
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put1/38

## Code
## Description
## Links
201Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
## POST
POST/api/v1/auth/loginLogin
Inicia sesión con correo y contraseña y devuelve el token de acceso.
Try it out
## Example Value
## {
## "access_token": "string",
## "token_type": "bearer",
## "user": {
## "id": "string",
## "email": "string",
## "full_name": "string",
## "username": "string"
## }
## }
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put2/38

No parameters
Request bodyapplication/json
## Schema
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
required
## Example Value
## {
## "email": "user@example.com",
## "password": "string"
## }
## Example Value
## {
## "access_token": "string",
## "token_type": "bearer",
## "user": {
## "id": "string",
## "email": "string",
## "full_name": "string",
## "username": "string"
## }
## }
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put3/38

## Code
## Description
## Links
## POST
## POST
/api/v1/auth/logoutLogout
Cierra la sesión actual del usuario autenticado.
Try it out
No parameters
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
## GET
## GET
/api/v1/auth/meMe
Obtiene el perfil del usuario autenticado a partir de su token.
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
## Example Value
## {
## "message": "string",
"code": "SUCCESS"
## }
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put4/38

Try it out
No parameters
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
## POST
POST/api/v1/auth/confirmConfirm Email
Confirma el email de un usuario usando la Service Key de Supabase.
Este endpoint debe usarse solo desde un entorno seguro (backend/admin). Requiere la cabecera X-
Service-Key con el valor de SUPABASE_SERVICE_KEY.
Try it out
NameDescription
X-Service-
## Key *
string
## (header)
X-Service-Key
Request body
## Parameters
## Example Value
## {
## "id": "string",
## "email": "string",
## "full_name": "string",
## "username": "string"
## }
## Parameters
required
required
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put5/38

application/json
## Schema
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
## Example Value
## {
## "user_id": "string"
## }
## Example Value
## {
## "message": "string",
"code": "SUCCESS"
## }
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put6/38

## Telemetría
## POST
## POST
/api/v1/telemetry/saveGuardar datos de telemetría
Recibe datos de GPS, batería y velocidad desde el ESP32 y los guarda en la base de datos
Try it out
No parameters
Request bodyapplication/json
## Schema
## Responses
## Code
## Description
## Links
201Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
## Parameters
required
## Example Value
## {
## "vehicle_id": "string",
## "lat": 0,
## "lng": 0,
## "battery_v": 0,
## "speed_kmh": 0
## }
## Example Value
## {
## "id": 0,
## "vehicle_id": "string",
## "lat": 0,
## "lng": 0,
## "battery_v": 0,
## "speed_kmh": 0,
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put7/38

## Code
## Description
## Links
422Validation Error
Media type
application/json
## Schema
No links
## GET
## GET
/api/v1/telemetry/vehicle/{vehicle_id}Obtener historial de telemetría
Trae el historial de ubicaciones, batería y velocidad de un vehículo
Try it out
NameDescription
vehicle_id *
string
## (path)
vehicle_id
limit
integer
## (query)
maximum: 500
minimum: 1
Número máximo de registros
Default value : 50
## 50
"recorded_at": "2026-05-05T15:58:37.500Z"
## }
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
required
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put8/38

## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
## GET
## GET
## /api/v1/telemetry/vehicle/{vehicle_id}
## /latest
Obtener última posición
Trae el último punto de ubicación, batería y velocidad del vehículo
## Example Value
## [
## {
## "id": 0,
## "vehicle_id": "string",
## "lat": 0,
## "lng": 0,
## "battery_v": 0,
## "speed_kmh": 0,
"recorded_at": "2026-05-05T15:58:37.501Z"
## }
## ]
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put9/38

Try it out
NameDescription
vehicle_id *
string
## (path)
vehicle_id
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
## Parameters
required
## Example Value
## {
## "id": 0,
## "vehicle_id": "string",
## "lat": 0,
## "lng": 0,
## "battery_v": 0,
## "speed_kmh": 0,
"recorded_at": "2026-05-05T15:58:37.503Z"
## }
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put10/38

## Code
## Description
## Links
## Vehicles
## GET
GET/api/v1/vehiclesList Vehicles
Try it out
No parameters
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
## POST
POST/api/v1/vehiclesCreate Vehicle
Try it out
## ]
## }
## Parameters
## Example Value
## [
## {
## "nickname": "string",
## "vin": "string",
## "total_km": 0,
"is_neutral": false,
## "id": "string",
## "owner_id": "string",
"created_at": "2026-05-05T15:58:37.505Z"
## }
## ]
## Parameters
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put11/38

No parameters
Request bodyapplication/json
## Schema
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
required
## Example Value
## {
## "nickname": "string",
## "vin": "string",
## "total_km": 0,
"is_neutral": false
## }
## Example Value
## {
## "nickname": "string",
## "vin": "string",
## "total_km": 0,
"is_neutral": false,
## "id": "string",
## "owner_id": "string",
"created_at": "2026-05-05T15:58:37.507Z"
## }
## Example Value
## {
## "detail": [
## {
## "loc": [
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put12/38

## Code
## Description
## Links
## GET
## GET
/api/v1/vehicles/{vehicle_id}Get Vehicle
Try it out
NameDescription
vehicle_id *
string
## (path)
vehicle_id
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation ErrorNo links
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
required
## Example Value
## {
## "nickname": "string",
## "vin": "string",
## "total_km": 0,
"is_neutral": false,
## "id": "string",
## "owner_id": "string",
"created_at": "2026-05-05T15:58:37.508Z"
## }
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put13/38

## Code
## Description
## Links
Media type
application/json
## Schema
## PUT
## PUT
/api/v1/vehicles/{vehicle_id}Update Vehicle
Try it out
NameDescription
vehicle_id *
string
## (path)
vehicle_id
Request bodyapplication/json
## Schema
## Responses
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
required
required
## Example Value
## {
## "nickname": "string",
## "vin": "string",
## "total_km": 0,
"is_neutral": true
## }
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put14/38

## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
## DELETE
DELETE/api/v1/vehicles/{vehicle_id}Delete Vehicle
Try it out
NameDescription
vehicle_id *
string
vehicle_id
## Example Value
## {
## "nickname": "string",
## "vin": "string",
## "total_km": 0,
"is_neutral": false,
## "id": "string",
## "owner_id": "string",
"created_at": "2026-05-05T15:58:37.510Z"
## }
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
required
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put15/38

NameDescription
## (path)
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
## Maintenance
## POST
## POST
## /api/v1/vehicles/{vehicle_id}
## /maintenance
## Create Maintenance
## Example Value
## "string"
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put16/38

Try it out
NameDescription
vehicle_id *
string
## (path)
vehicle_id
Request bodyapplication/json
## Schema
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
## Parameters
required
required
## Example Value
## {
## "component": "string",
## "km_at_service": 0
## }
## Example Value
## {
## "id": 0,
## "vehicle_id": "string",
## "component": "string",
## "km_at_service": 0,
"service_date": "2026-05-05T15:58:37.514Z"
## }
## Example Value
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put17/38

## Code
## Description
## Links
## GET
## GET
## /api/v1/vehicles/{vehicle_id}
## /maintenance
## List Maintenance
Try it out
NameDescription
vehicle_id *
string
## (path)
vehicle_id
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
required
## Example Value
## [
## {
## "id": 0,
## "vehicle_id": "string",
## "component": "string",
## "km_at_service": 0,
"service_date": "2026-05-05T15:58:37.515Z"
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put18/38

## Code
## Description
## Links
422Validation Error
Media type
application/json
## Schema
No links
## GET
## GET
/api/v1/maintenance/{log_id}Get Maintenance
Try it out
NameDescription
log_id *
integer
## (path)
log_id
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
No links
## }
## ]
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
required
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put19/38

## Code
## Description
## Links
## Schema
422Validation Error
Media type
application/json
## Schema
No links
## PUT
PUT/api/v1/maintenance/{log_id}Update Maintenance
Try it out
NameDescription
log_id *
integer
## (path)
log_id
Request bodyapplication/json
## Schema
## Example Value
## {
## "id": 0,
## "vehicle_id": "string",
## "component": "string",
## "km_at_service": 0,
"service_date": "2026-05-05T15:58:37.517Z"
## }
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
required
required
## Example Value
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put20/38

## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
## DELETE
DELETE/api/v1/maintenance/{log_id}Delete Maintenance
## {
## "component": "string",
## "km_at_service": 0
## }
## Example Value
## {
## "id": 0,
## "vehicle_id": "string",
## "component": "string",
## "km_at_service": 0,
"service_date": "2026-05-05T15:58:37.519Z"
## }
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put21/38

Try it out
NameDescription
log_id *
integer
## (path)
log_id
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
## Parameters
required
## Example Value
## "string"
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put22/38

## GET
## GET
## /api/v1/maintenance/life
## /{vehicle_id}
## Get Component Life
Try it out
NameDescription
vehicle_id *
string
## (path)
vehicle_id
component *
string
## (query)
component
interval_km *
number
## (query)
interval_km
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
## Parameters
required
required
required
## Example Value
## {
## "vehicle_id": "string",
## "component": "string",
## "total_km": 0,
## "last_service_km": 0,
## "life_percent": 0
## }
## Example Value
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put23/38

## Code
## Description
## Links
## Commands
## POST
## POST
## /api/v1/vehicles/{vehicle_id}
## /commands
## Create Command
Try it out
NameDescription
vehicle_id *
string
## (path)
vehicle_id
Request bodyapplication/json
## Schema
## Responses
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
required
required
## Example Value
## {
## "action": "string"
## }
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put24/38

## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
## GET
## GET
## /api/v1/vehicles/{vehicle_id}
## /commands
## List Commands
Try it out
## Example Value
## {
## "id": 0,
## "vehicle_id": "string",
## "action": "string",
## "status": "string",
"created_at": "2026-05-05T15:58:37.528Z",
"executed_at": "2026-05-05T15:58:37.528Z"
## }
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put25/38

NameDescription
vehicle_id *
string
## (path)
vehicle_id
status
## (query)
status
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
required
## Example Value
## [
## {
## "id": 0,
## "vehicle_id": "string",
## "action": "string",
## "status": "string",
"created_at": "2026-05-05T15:58:37.529Z",
"executed_at": "2026-05-05T15:58:37.529Z"
## }
## ]
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put26/38

## Code
## Description
## Links
## GET
## GET
/api/v1/commands/{command_id}Get Command
Try it out
NameDescription
command_id *
integer
## (path)
command_id
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
No links
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
required
## Example Value
## {
## "id": 0,
## "vehicle_id": "string",
## "action": "string",
## "status": "string",
"created_at": "2026-05-05T15:58:37.531Z",
"executed_at": "2026-05-05T15:58:37.531Z"
## }
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put27/38

## Code
## Description
## Links
## Schema
## PUT
## PUT
## /api/v1/commands/{command_id}
## /execute
## Execute Command
Try it out
NameDescription
command_id *
integer
## (path)
command_id
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
required
## Example Value
## {
## "id": 0,
## "vehicle_id": "string",
## "action": "string",
## "status": "string",
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put28/38

## Code
## Description
## Links
422Validation Error
Media type
application/json
## Schema
No links
## Alerts
## POST
POST/api/v1/vehicles/{vehicle_id}/alertsCreate Alert
Try it out
NameDescription
vehicle_id *
string
## (path)
vehicle_id
Request bodyapplication/json
## Schema
"created_at": "2026-05-05T15:58:37.532Z",
"executed_at": "2026-05-05T15:58:37.532Z"
## }
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
required
required
## Example Value
## {
## "type": "string",
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put29/38

## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
## GET
GET/api/v1/alertsList Alerts
## "message": "string"
## }
## Example Value
## {
## "id": 0,
## "vehicle_id": "string",
## "owner_id": "string",
## "type": "string",
## "message": "string",
"is_read": true,
## "created_at": "string"
## }
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put30/38

Try it out
NameDescription
is_read
## (query)
is_read
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
## Parameters
## Example Value
## [
## {
## "id": 0,
## "vehicle_id": "string",
## "owner_id": "string",
## "type": "string",
## "message": "string",
"is_read": true,
## "created_at": "string"
## }
## ]
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put31/38

## Code
## Description
## Links
## GET
## GET
/api/v1/alerts/{alert_id}Get Alert
Try it out
NameDescription
alert_id *
integer
## (path)
alert_id
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
422Validation Error
Media type
application/json
## Schema
No links
## }
## ]
## }
## Parameters
required
## Example Value
## {
## "id": 0,
## "vehicle_id": "string",
## "owner_id": "string",
## "type": "string",
## "message": "string",
"is_read": true,
## "created_at": "string"
## }
## Example Value
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put32/38

## Code
## Description
## Links
## PUT
PUT/api/v1/alerts/{alert_id}/readMark Alert As Read
Try it out
NameDescription
alert_id *
integer
## (path)
alert_id
## Responses
## Code
## Description
## Links
200Successful Response
Media type
application/json
Controls Accept header.
## Schema
No links
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
## Parameters
required
## Example Value
## {
## "id": 0,
## "vehicle_id": "string",
## "owner_id": "string",
## "type": "string",
## "message": "string",
"is_read": true,
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put33/38

## Code
## Description
## Links
422Validation Error
Media type
application/json
## Schema
No links
## Schemas
AlertCreateCollapse allobject
type*string[1, 30] characters
messageExpand all(string | null)
AlertResponseCollapse allobject
id*
integer
vehicle_id*
string
owner_id*
string
type*
string
message*
Expand all(string | null)
is_read*boolean
created_at*string
AuthResponseCollapse allobject
## "created_at": "string"
## }
## Example Value
## {
## "detail": [
## {
## "loc": [
## "string",
## 0
## ],
## "msg": "string",
## "type": "string"
## }
## ]
## }
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put34/38

Representa la respuesta de autenticación con token y datos del usuario.
access_token*string
token_typeExpand allstring
user*
Expand allobject
CommandCreateCollapse allobject
action*string[1, 20] characters
CommandResponseCollapse allobject
id*integer
vehicle_id*string
action*string
status*string
created_at*stringdate-time
executed_at*Expand all(string | null)
ComponentLifeResponseCollapse allobject
vehicle_id*
string
component*
string
total_km*
number
last_service_km*
Expand all(number | null)
life_percent*Expand all(number | null)
ConfirmEmailRequestCollapse allobject
Solicitud para confirmar el email de un usuario (admin only).
user_id*string
HTTPValidationErrorCollapse allobject
detailExpand allarray<object>
LoginRequestCollapse allobject
Representa el cuerpo de la solicitud de inicio de sesión.
email*stringemail
password*string
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put35/38

MaintenanceCreateCollapse allobject
component*
string[1, 20] characters
km_at_service*number≥ 0
MaintenanceResponseCollapse allobject
id*integer
vehicle_id*string
component*string
km_at_service*number
service_date*stringdate-time
MaintenanceUpdateCollapse allobject
componentExpand all(string | null)
km_at_serviceExpand all(number | null)
MessageResponseCollapse allobject
Representa una respuesta simple de confirmación.
message*string
codeExpand allstring
RegisterRequestCollapse allobject
Representa el cuerpo de la solicitud de registro.
email*stringemail
password*string
full_name*string
TelemetryRequestCollapse allobject
Esquema de solicitud para enviar datos de telemetría desde el ESP32.
vehicle_id*Expand allstring
lat*Expand allnumber
lng*
Expand allnumber
battery_v*Expand allnumber
speed_kmhExpand allnumber
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put36/38

TelemetryResponseCollapse allobject
Esquema de respuesta después de guardar telemetría.
id*
integer
vehicle_id*
string
lat*
number
lng*
number
battery_v*
number
speed_kmh*
number
recorded_at*
stringdate-time
UserResponseCollapse allobject
Representa el usuario expuesto por la API.
id*
string
email*
string
full_name
Expand all(string | null)
usernameExpand all(string | null)
ValidationErrorCollapse allobject
loc*
Expand allarray<(string | integer)>
msg*string
type*string
VehicleCreateCollapse allobject
nickname*
string[1, 30] characters
vin*string[1, 17] characters
total_km
Expand allnumber≥ 0
is_neutralExpand allboolean
VehicleResponseCollapse allobject
nickname*
string[1, 30] characters
vin*string[1, 17] characters
total_km
Expand allnumber≥ 0
is_neutralExpand allboolean
id*string
owner_id*string
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put37/38

created_at*stringdate-time
VehicleUpdateCollapse allobject
nicknameExpand all(string | null)
vin
Expand all(string | null)
total_kmExpand all(number | null)
is_neutralExpand all(boolean | null)
5/5/26, 9:59 a.m.Retrofit Smart-Bike API - Swagger UI
https://api-mocha-omega-45.vercel.app/docs#/Alerts/mark_alert_as_read_api_v1_alerts__alert_id__read_put38/38