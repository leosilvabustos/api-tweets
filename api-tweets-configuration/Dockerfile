FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/api-tweets-configuration-1.0-SNAPSHOT.jar app.jar
EXPOSE 8888
ENTRYPOINT exec java -jar app.jar