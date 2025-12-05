# Use imagem base com Java 17
FROM eclipse-temurin:17-jdk-alpine

# Defina o diretório de trabalho
WORKDIR /app

# Copie os arquivos Maven Wrapper e pom.xml
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Copie o código-fonte
COPY src src

# Permissão para o Maven Wrapper
RUN chmod +x mvnw

# Build do projeto sem rodar os testes
RUN ./mvnw clean package -DskipTests

# Copie o jar gerado para a imagem
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java","-jar","app.jar"]
