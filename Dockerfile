# Estágio 1: Build (Compilação do projeto)
FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app

# Copia o Maven Wrapper e o pom.xml primeiro (otimização de cache do Docker)
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Dá permissão de execução para o script do Maven
RUN chmod +x mvnw

# Baixa as dependências do projeto
RUN ./mvnw dependency:go-offline

# Copia o código-fonte
COPY src ./src

# Faz o build do projeto gerando o .jar (ignorando testes, pois rodarão no CI/CD)
RUN ./mvnw clean package -DskipTests

# Estágio 2: Imagem final de Execução (Leve e segura)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia apenas o arquivo .jar gerado no estágio 1
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Comando que inicia o Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]