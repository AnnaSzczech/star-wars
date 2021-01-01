FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=star-wars.jar
ADD ${JAR_FILE} star-wars.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/star-wars.jar"]