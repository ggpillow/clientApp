# ClientApp

## Описание
Приложение ClientApp — это простое RESTful API для управления клиентами и их контактами. Позволяет создавать, читать, обновлять и удалять клиентов и их контактную информацию.

## Технологии
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA (Hibernate)
- PostgreSQL
- Docker и Docker Compose
- OpenAPI (Swagger)
- JUnit и Mockito (для тестирования)

## Запуск

1. Клонируй репозиторий
2. Создай файл .env и заполни:
   ```env
      # PostgreSQL настройки (для Docker Compose)
      POSTGRES_DB=clientdb
      POSTGRES_USER=ТВОЙ_ЛОГИН
      POSTGRES_PASSWORD=ТВОЙ_ПАРОЛЬ

      # Spring Boot datasource (используются те же значения)
      SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/clientdb
      SPRING_DATASOURCE_USERNAME=ТВОЙ_ЛОГИН
      SPRING_DATASOURCE_PASSWORD=ТВОЙ_ПАРОЛЬ
По умолчанию логин и пароль — postgres, если ты не менял их в docker-compose.yml.
3. Собери проект (если не собран):
   ```env
   mvn clean package
4. Запусти приложение через Docker Compose:
   ```env
   docker-compose up --build 
5. Открой Swagger UI для тестирования API:
   http://localhost:8080/swagger-ui/index.html

## API
1. Клиенты:
   - GET /clients — список клиентов 
   - GET /clients/{id} — получить клиента по ID 
   - POST /clients — создать клиента 
   - PUT /clients/{id} — обновить клиента 
   - DELETE /clients/{id} — удалить клиента

2. Контакты:
   - GET /contacts — список контактов 
   - GET /contacts/{id} — получить контакт по ID 
   - POST /contacts — создать контакт 
   - PUT /contacts/{id} — обновить контакт 
   - DELETE /contacts/{id} — удалить контакт

## Тестирование
Юнит-тесты написаны с использованием JUnit и Mockito.

Для запуска тестов:
mvn test
   
## Безопасность
Реализована базовая аутентификация с Spring Security.

Автор: Анна Волкова
Дата: 03.07.2025
