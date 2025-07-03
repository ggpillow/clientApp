#Официальный образ OpenJDK
FROM openjdk:17-jdk-slim

#Рабочая директория
WORKDIR /app

#Копирование собранного jar
COPY target/clientapp-0.0.1-SNAPSHOT.jar app.jar

#Команда запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]