# API REST - Sistema Hospitalario

API desarrollada con Spring Boot para gestionar
doctores, pacientes y citas médicas.

## Descripción
Backend REST que permite gestionar un sistema
hospitalario con relaciones entre entidades,
validaciones y manejo global de errores.

## Endpoints

### Doctores
| Método | URL | Descripción |
|--------|-----|-------------|
| POST | /doctores | Crear doctor |
| GET | /doctores | Listar doctores |
| GET | /doctores/{id} | Obtener doctor |
| PUT | /doctores/{id} | Actualizar doctor |
| DELETE | /doctores/{id} | Eliminar doctor |
| GET | /doctores/{id}/citas | Citas del doctor |

### Pacientes
| Método | URL | Descripción |
|--------|-----|-------------|
| POST | /pacientes | Crear paciente |
| GET | /pacientes | Listar pacientes |
| GET | /pacientes/{id} | Obtener paciente |
| PUT | /pacientes/{id} | Actualizar paciente |
| DELETE | /pacientes/{id} | Eliminar paciente |
| GET | /pacientes/{id}/citas | Citas del paciente |

### Citas
| Método | URL | Descripción |
|--------|-----|-------------|
| POST | /citas | Crear cita |
| GET | /citas | Listar citas |
| GET | /citas/{id} | Obtener cita |
| PUT | /citas/{id} | Actualizar cita |
| DELETE | /citas/{id} | Eliminar cita |
| GET | /citas/estado/{estado} | Filtrar por estado |

## Tecnologías
- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- PostgreSQL
- Maven
- Postman
- Validation (@Valid)

## Conceptos aplicados
- Relaciones JPA (@OneToMany, @ManyToOne)
- Validaciones con @Valid
- Manejo global de errores (@ControllerAdvice)
- Excepciones personalizadas
- Arquitectura en 6 capas

## Estructura del proyecto
- model → Doctor, Paciente, Cita (Entities)
- repository → Repositories JPA
- service → Lógica de negocio
- controller → Endpoints REST
- dto → Objetos de entrada
- exception → Manejo global de errores

## Base de datos
- Base de datos: db_hospital
- Tablas: doctor, paciente, cita

## Autor
Ricardo — Estudiante de Desarrollo de Software
Cibertec Perú — 4to ciclo
