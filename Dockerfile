FROM adoptopenjdk/openjdk17
EXPOSE 8080
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} demo.jar
ENTRYPOINT ["java", "-jar", "/demo.jar"]
