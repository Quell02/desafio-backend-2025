# Etapa 1: build
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copiar arquivos necessários para build
COPY mvnw pom.xml ./
COPY .mvn .mvn
COPY src src

# Dar permissão ao mvnw e buildar
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Etapa 2: runtime
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiar JAR gerado da etapa de build
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expor porta dinâmica
ENV PORT=8080
EXPOSE $PORT

# Comando para rodar
ENTRYPOINT ["java","-jar","app.jar"]
