FROM amazoncorretto:17-alpine-jdk
MAINTAINER ENZI
COPY target/enzogiacoia-0.0.1-SNAPSHOT.jar enzogiacoia-app.jar
ENTRYPOINT ["java", "-jar", "/enzogiacoia-app.jar"]