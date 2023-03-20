FROM openjdk:8
EXPOSE 8090
COPY target/com.app.solware.jar /app/com.app.solware.jar
ENTRYPOINT ["java", "-jar", "/app/com.app.solware.jar"]