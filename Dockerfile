#
# Build stage
#

FROM maven:3.6.3-jdk-11-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package

#
# Package stage
#

FROM openjdk:11-jre-slim
ARG APP_NAME="person-generator"
WORKDIR /app
EXPOSE 8080
COPY --from=build /app/target/${APP_NAME}.jar ./app.jar
CMD ["java","-jar", "./app.jar"]