FROM amazoncorretto:21-alpine

WORKDIR /app

COPY target/myapp.jar myapp.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "myapp.jar"]