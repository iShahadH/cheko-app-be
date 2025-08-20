# Cheko App

## 🚀 Setup Instructions

This project requires **PostgreSQL** and **MinIO**.  
We use two environment configuration files:
- `.env` → Used by **Docker Compose**.
- `env.properties` → Used by **Spring Boot**.

⚠️ Both files are **ignored by Git** for security reasons. Each developer must create them locally.

### 1. Create `.env` in the project root
Copy the example and update values:
```sh
cp .env.example .env
```

### 2. Add `env.properties` file in `src/main/resources/`
This file is used by Spring Boot for database and MinIO configurations.

```properties
# PostgreSQL
spring.datasource.url=your_url
spring.datasource.username=your_username
spring.datasource.password=your_pass

# MinIO
minio.access-key=your_access_key
minio.secret-key=your_secret_key
```

### 3. Run with local (without Docker)
mvn clean package
mvn spring-boot:run

### 4. Run with Docker Compose
mvn clean package
docker-compose up --build