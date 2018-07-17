FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/api-tweets-createtweet-1.0-SNAPSHOT.jar app.jar
EXPOSE 8902
ENTRYPOINT exec java -jar app.jar