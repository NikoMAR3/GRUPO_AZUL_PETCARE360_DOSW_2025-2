# PETCARE 360

---

## 🌱 Estrategia de Ramas (GitFlow)

Para mantener un flujo de trabajo ordenado en equipo, usaremos **GitFlow adaptado**:

- **`main`**
    - Rama principal de producción.
    - Contiene únicamente código estable y listo para despliegue.
    - Solo recibe merges desde `release/*` o `hotfix/*`.

- **`develop`**
    - Rama de integración.
    - Contiene el código más actualizado y aprobado de las nuevas funcionalidades.
    - Todas las ramas de trabajo (`feature/*`, `fix/*`) se integran aquí mediante *pull requests*.

- **`feature/*`**
    - Para nuevas funcionalidades.
    - Se crean a partir de `develop`.
    - Convención de nombre:
      ```
      feature/<nombre-corto-descriptivo>
      ```
      Ejemplo:  
      `feature/login-usuarios`  
      `feature/api-pets`

- **`fix/*`**
    - Para corrección de bugs detectados en `develop`.
    - Convención de nombre:
      ```
      fix/<descripcion-breve>
      ```
      Ejemplo:  
      `fix/carga-datos`

- **`release/*`**
    - Preparación de versiones antes de pasar a producción.
    - Se crean desde `develop`.
    - Convención:
      ```
      release/<version>
      ```
      Ejemplo:  
      `release/1.0.0`

- **`hotfix/*`**
    - Correcciones urgentes en producción (`main`).
    - Convención:
      ```
      hotfix/<descripcion>
      ```
      Ejemplo:  
      `hotfix/error-arranque`

### 🦐 Estructura commits 
 - `tipo(<área>): mensaje breve en presente`
### Tipos principales:
- **feat** → Nueva funcionalidad.
- **fix** → Corrección de bug.
- **docs** → Cambios en documentación.
- **style** → Formato (espacios, indentación, sin cambios de lógica).
- **refactor** → Cambios de código que no corrigen bug ni añaden funcionalidad.
- **test** → Añadir o modificar pruebas.
- **chore** → Tareas varias (build, configuración, dependencias).

### Ejemplos:

- feat(auth): agregar endpoint de login
- fix(api): corregir error en validación de mascotas
- docs(readme): añadir sección de instalación
- refactor(service): optimizar consulta a base de datos

---

## ⚙️ Tecnologías

- **Java 17**
- **Spring Boot 3.5.6**
- **Maven** (gestión de dependencias y build)
- **Lombok** (reducción de código boilerplate)
- **JUnit 5 / Spring Boot Test** (pruebas unitarias e integración)
- **Springdoc OpenAPI** (documentación Swagger UI)
- **Jacoco** (cobertura de código)
- **SonarQube** (análisis estático de calidad de código)

---

## 📦 Dependencias Clave

- `spring-boot-starter`
- `lombok`
- `spring-boot-starter-test`
- `junit-jupiter`
- `springdoc-openapi-starter-webmvc-ui`
- `jacoco-maven-plugin`
- `sonar-maven-plugin`

---

## 🚀 Requisitos Previos

- Java 17 instalado
- Maven 3.9+ instalado (o usar el wrapper `./mvnw`)
- IDE recomendado: IntelliJ IDEA o Eclipse con soporte para Spring Boot

---

## ▶️ Ejecución del Proyecto

1. Clonar el repositorio:
   ```
   git clone https://github.com/NikoMAR3/GRUPO_AZUL_PETCARE360_DOSW_2025-2.git

2. Utilizar comando de Maven

    `mvn clean compile`

---

## 📚 Explicacion Diagramas

![Petcare360- Diagrama Contexto.png](docs/images/Petcare360-%20Diagrama%20Contexto.png)

![Petcare360_Diagrama de Casos.png](docs/images/Petcare360_Diagrama%20de%20Casos.png)

## 🧩 Patrones 

### Justificacion