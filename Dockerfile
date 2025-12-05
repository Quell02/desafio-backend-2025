# Stage 1: Build com Maven
FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /app

# Copiar arquivos essenciais do Maven
COPY mvnw pom.xml ./
COPY .mvn .mvn
COPY src src

# Dar permissão para o mvnw
RUN chmod +x mvnw

# Rodar build e gerar JAR
RUN ./mvnw clean package -DskipTests

# DEBUG: listar arquivos da pasta target para verificar se o JAR foi criado
RUN ls -l target

# Stage 2: Runtime
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copiar o JAR gerado no build
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expor porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
