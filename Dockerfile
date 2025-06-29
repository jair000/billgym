# Etapa 1: Construcción del proyecto
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagen final con solo el .jar
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/app.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
