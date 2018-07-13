FROM openjdk:10-jre-slim
COPY ./target/*.jar /app.jar
WORKDIR /
EXPOSE 8282
CMD ["java", "-jar", "app.jar"]