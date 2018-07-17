FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/api-tweets-createorupdateuser-1.0-SNAPSHOT.jar app.jar
EXPOSE 8901
ENTRYPOINT exec java -jar app.jar