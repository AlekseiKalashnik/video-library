# Build the project into executable war
FROM maven:3.8.6-openjdk-18-slim AS buildImage
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Run the application
FROM openjdk:11.0.11-jre-slim
COPY --from=buildImage /home/app/target/service-1.0-SNAPSHOT.jar /usr/local/lib/service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/service.jar"]
