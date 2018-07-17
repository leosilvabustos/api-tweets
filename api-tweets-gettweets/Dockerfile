FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/api-tweets-gettweets-1.0-SNAPSHOT.jar app.jar
EXPOSE 8000
ENTRYPOINT exec java -jar app.jar