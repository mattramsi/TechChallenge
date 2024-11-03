# Use uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o JAR para o contêiner
COPY target/techchallengev2.jar /app/techchallengev2.jar

ENV SPRING_DEVTOOLS_RESTART_ENABLED=false

# Comando para executar o JAR
CMD ["java", "-jar", "techchallengev2.jar"]