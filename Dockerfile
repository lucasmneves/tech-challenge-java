FROM amazoncorretto:17

LABEL authors="Leandro Henrique" \
      description="Arquivo Dockerfile para criar uma imagem com o Java 17 e o JAR da aplicação."

RUN mkdir -p /app

COPY target/fiapBurger-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8989

CMD java -jar /app/app.jar]