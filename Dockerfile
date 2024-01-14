FROM openjdk:17
WORKDIR /was
ARG JAR_FILE=build/libs/hackathon-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} hackathon-was.jar
ENTRYPOINT ["java","-jar","./hackathon-was.jar"]
