FROM amazoncorretto:17

RUN mkdir -p /app

WORKDIR /app

COPY target/fiapBurger-0.0.1-SNAPSHOT.jar .

EXPOSE 8989

CMD ["java", "-jar", "fiapBurger-0.0.1-SNAPSHOT.jar"]
