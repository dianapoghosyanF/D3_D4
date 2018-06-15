FROM openjdk:8-jdk-alpine
MAINTAINER dianpoghosyan@yahoo.com
VOLUME /tmp
#EXPOSE 2375
#export DOCKER_HOST=tcp://localhost:2375
#ARG JAR_FILE=target/api-1.0-SNAPSHOT.jar api.jar
ARG JAR_FILE
COPY ${JAR_FILE} api.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api.war"]