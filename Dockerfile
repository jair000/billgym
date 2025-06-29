# Etapa 1: Construcción del proyecto
FROM eclipse-temurin:21-jdk AS builder

# Crear y entrar al directorio del proyecto
WORKDIR /app

# Copiar todo el contenido del proyecto
COPY . .

# Dar permisos de ejecución al script mvnw (evita error 126)
RUN chmod +x mvnw

# Construir el proyecto sin ejecutar pruebas
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagen final con solo el .jar generado
FROM eclipse-temurin:21-jdk

# Crear y entrar al directorio donde correrá el jar
WORKDIR /app

# Copiar el .jar compilado desde el contenedor builder
COPY --from=builder /app/target/*.jar app.jar

# Exponer el puerto 8080 (o el que uses en application.properties)
EXPOSE 8080

# Comando que ejecuta la aplicación
CMD ["java", "-jar", "app.jar"]
