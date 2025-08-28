# Application with clean architecture
Aplicación web desarrollada en Intellij Idea con **Java EE** y **Spring Boot**, siguiendo los principios de **Clean Architecture (Arquitectura Limpia)**. Este proyecto organiza el código de forma modular y escalable, separando las capas de dominio, aplicación e infraestructura para favorecer el mantenimiento y la extensibilidad.

## 🚀 Tecnologías utilizadas
- **Maven**
- **Spring Boot 3.5.5**
- **Java 21**   
- **JUnit 5** para pruebas unitarias e integración  
- **IntelliJ IDEA** (recomendado como IDE)

## 📦 Dependias en Spring Boot
- **Spring Boot Starter Data JPA**
- **Spring Boot Starter Thymeleaf**
- **Spring Boot Starter  Web**
- **Spring Boot Devtools**
- **Mysql Connector J**

## 📂 Estructura del Proyecto 
```
> .idea
> .mvc
> src
 ├── main
 │ └── java
 │ └── com.esfe.cleanapp
 │ ├── application
 │ │ └── usercase
 │ │ └── CheckDbHealthService.java
 │ ├── domain
 │ │ ├── model
 │ │ │ └── Usuario.java
 │ │ └── port
 │ │ ├── in
 │ │ │ └── CheckDbHealthUseCase.java (interfas)
 │ │ └── out
 │ │ └── SqlHealthPort.java (interfaz)
 │ ├── infrastructure
 │ │ ├── config
 │ │ │ └── BeanConfig.java
 │ │ ├── persistence
 │ │ │ └── adapter
 │ │ │ └── SqlHealthAdapter.java
 │ │ └── web
 │ │ └── HealthController.java
 │ └── CleanappApplication.java
 │ └── resources
 │    └── static
 │    └── templates
 │    └── application.yml
> test
 ├── jav
 └── com.esfe.cleanapp
  ├── DbConnectionSmokeTest.java
  └── CleanappApplicationTests.java
 ├── test
 │ └── java
 └── resources
  └── application.yml
```

## 🧩 Principios de Arquitectura Limpia

La aplicación sigue la orientación hacia el **dominio**:

1. **Domain (Dominio)**  
   - Contiene las entidades (`Usuario`) y los puertos (`in` y `out`).  
   - Define las reglas del negocio, independientes de frameworks o bases de datos.  

2. **Application (Casos de uso)**  
   - Implementa los servicios que orquestan la lógica de negocio (`CheckDbHealthService`).  

3. **Infrastructure (Infraestructura)**  
   - Contiene las implementaciones técnicas como adaptadores (`SqlHealthAdapter`), controladores web (`HealthController`) y configuraciones (`BeanConfig`).  

## ⚙️ Configuración

El archivo `application.yml` se encuentra en `src/main/resources/`.

Ejemplo:

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://<HOST>:<PUERTO>/<DB>?ssl-mode=REQUIRED
    username: <USUARIO>
    password: <CONTRASEÑA>
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: none
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect

👉 Reemplaza <HOST>, <PUERTO>, <DB>, <USUARIO> y <CONTRASEÑA> con tus datos reales de conexión a la base de datos.
```

⚠️ Importante:

- No subas credenciales reales (username, password, host) a tu repositorio.
- Puedes añadir un archivo application-example.yml como referencia y mantener tu application.yml real fuera de control de versiones (.gitignore).}

## ▶️ Ejecución

1. Clonar el repositorio:
```
git clone https://github.com/victoriavalencia06/cleanapp.git
cd cleanapp
```
2. Esperar a ue cargen las dependencias de maven
3. La app se levanta en:
http://localhost:8080

## 📊 Estado del Proyecto
Funcionalidades implementadas:
- Estructura Clean Architecture completa
- Configuración de base de datos MySQL
- Endpoint de verificación de salud de la base de datos
- Pruebas de smoke test para conexión a BD
