FROM openjdk:22-slim-bullseye

WORKDIR /app
COPY target/*.jar ./
EXPOSE 3000
EXPOSE 3001
CMD ["java", "-jar", "isosim-1.0.0.jar"]
