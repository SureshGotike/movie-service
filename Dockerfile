FROM openjdk:8
ADD build/libs/movieservice-0.0.1-SNAPSHOT.jar movieservice.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "movieservice.jar"]