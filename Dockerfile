# Stage 1: build do Maven
FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /app

# Copiar arquivos essenciais do Maven
COPY mvnw pom.xml ./
COPY .mvn .mvn
COPY src src

# Dar permissão e rodar o build
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Stage 2: runtime
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copiar o JAR gerado no build
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expor porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java","-jar","app.jar"]
