FROM openjdk:8
ADD build/libs/movieservice-0.0.1-SNAPSHOT.jar movieservice.jar
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongo:27017/mongodb", "-Djava.security.egd=file:/dev/./urandom","-jar", "movieservice.jar"]