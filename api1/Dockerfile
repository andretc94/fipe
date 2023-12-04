#
# Build stage
#
FROM maven:latest AS build
COPY ./src /home/app/src
COPY ./api /home/app/api
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:21-jdk-slim
COPY --from=build /home/app/target/*.jar service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","service.jar"]
