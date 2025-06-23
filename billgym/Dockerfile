# Etapa 1: compilar el proyecto
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Solo copia los archivos necesarios primero
COPY pom.xml .
COPY src ./src

# Luego compila el proyecto (esto creará el .jar en /app/target)
RUN mvn clean install -DskipTests

# Etapa 2: correr la aplicación
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
