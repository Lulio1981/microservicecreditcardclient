FROM openjdk:11
EXPOSE 8012
ARG JAR_FILE=target/microservice-credit-card-client-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]