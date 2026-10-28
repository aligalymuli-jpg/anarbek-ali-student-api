# Stage 1: Build stage using official Gradle + JDK 21 image
FROM gradle:8.10.2-jdk21 AS builder
WORKDIR /build
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle bootJar --no-daemon -x test

# Stage 2: Runtime stage using lightweight JRE 21 image
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /build/build/libs/*.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"]
