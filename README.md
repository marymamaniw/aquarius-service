
# Aquarius Service

Backend desarrollado para gestionar empleados y sincronizar datos con la aplicación web y móvil.
Este servicio proporciona autenticación con Spring Security y JWT, CRUD para gestión de Empleados, CRUD para gestión de Áreas y manejo de datos mediante una API REST.

## Requisitos

- **Java 17** o superior.
- **Maven** para gestionar las dependencias y construir el proyecto.
- **MySQL** para la base de datos (puedes usar Docker como alternativa).


## Instalación y Uso
### Opción 1: Sin Docker
1. **Clona el repositorio**:
  ```
  git clone https://github.com/marymamaniw/aquarius-service.git
  cd aquarius-service
  ```

2. **Configura la base de datos**:
   - Crea una base de datos en MySQL ejecutando los siguientes scripts:
     ```
     CREATE DATABASE IF NOT EXISTS aquarius_service_db;
     USE aquarius_service_db;
     CREATE USER 'admin'@'%' IDENTIFIED BY 'password';
     GRANT ALL PRIVILEGES ON aquarius_service_db.* TO 'admin'@'%';
     FLUSH PRIVILEGES;
     ```
   - Actualiza el archivo src/main/resources/application.yml con los datos de tu base de datos.
   - Flyway se encargará ejecutar los scripts para crear las tablas necesarias. (De igual forma aquí puedes encontrar los scripts: [src/main/resources/db/migration](https://github.com/marymamaniw/aquarius-service/tree/main/src/main/resources/db/migration) )
     
3. **Construye y ejecuta la aplicación**:
  ```
  mvn clean install
  mvn spring-boot:run
  ```

4. **Accede al servicio**:
   - La aplicación estará disponible en ``http://localhost:8080``

### Opción 2: Usando Docker
Si prefieres levantar la base de datos de esta forma, asegúrate de tener Docker y Docker Compose instalados en tu sistema y sigue estos pasos:
1. **Clona el repositorio**:
  ```
  git clone https://github.com/marymamaniw/aquarius-service.git
  cd aquarius-service
  ```
2. **Inicia la base de datos con Docker Compose**:
  ```
  docker-compose up -d
  ```
3. **Construye y ejecuta la aplicación**:
  ```
  mvn clean install
  mvn spring-boot:run
  ```
4. **Accede al servicio**:
   - La aplicación estará disponible en ``http://localhost:8080``
     
  
## Tecnologias utilizadas

- ![Spring Boot](https://img.shields.io/badge/-Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)

- ![Java](https://img.shields.io/badge/-Java-007396?style=for-the-badge&logo=java&logoColor=white)

- ![Spring Security](https://img.shields.io/badge/-Spring%20Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)

- ![Flyway](https://img.shields.io/badge/-Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white)

- ![MySQL](https://img.shields.io/badge/-MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

- ![Docker](https://img.shields.io/badge/-Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
