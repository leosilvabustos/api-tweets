FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/api-tweets-graphql-1.0-SNAPSHOT.jar app.jar
EXPOSE 8900
ENTRYPOINT exec java -jar app.jar