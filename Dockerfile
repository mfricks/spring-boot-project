FROM adoptopenjdk/openjdk11:jdk-11.0.9.1_1-alpine-slim
COPY target/springboot-com-postgres-1.0-SNAPSHOT.jar app.jar
CMD java -jar app.jar