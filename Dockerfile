# Etapa 1: build com Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copie arquivos essenciais
COPY pom.xml .
COPY src src

# Build do projeto
RUN mvn clean package -DskipTests

# Etapa 2: imagem final só com o JAR
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copie o JAR gerado da etapa de build
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

# Exponha porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java","-jar","app.jar"]
