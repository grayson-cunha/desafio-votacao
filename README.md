# Vote-Challenge

## Glossary

- Pauta -> VotingTopic
- Sessão de Voto -> VotingSession
- Associado -> Associate
- Vote -> Voto

## Environment Variables

- DB_HOST=localhost
- DB_NAME=vote-challenge
- DB_PASS="DB_PASS"
- DB_PORT=5432
- DB_USER=postgres

## Stack

- Java 21
- Spring Boot 3.4.5
- Postgres
- Flyway
- Lombok
- Gradle
- Swagger
- JUnit

## How to access the documentation?

Access the following link http://localhost:8080/swagger-ui/index.html

## How to run?

1. If you don`t have docker is important to install follow [this setup](https://docs.docker.com/desktop/?_gl=1*12sx6h4*_gcl_au*Mjg2NDY0ODY0LjE3NDc3ODg0ODg.*_ga*MTg5Mzk3ODM3OC4xNzQ3Nzg4NDg5*_ga_XJWPQMJYHQ*czE3NDc3ODg0ODgkbzEkZzEkdDE3NDc3ODg0ODkkajU5JGwwJGgwJGQwLVVOem9VZkVBbGZoSnpqQ2lENGFuUFNjam9CdFFRdVR3)
2. After that you can execute this `docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=1234 -d postgres`
3. Create the database with the name of your preference like vote-challenge
4. Set the enviroment variables in your Java IDE like Intellij
5. Run the application and the tables will be created with Flyway
6. The application can be acessed by localhost:8080

