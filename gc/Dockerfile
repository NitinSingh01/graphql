# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="14nitinsingh@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp


EXPOSE 9001

# The application's jar file
ARG JAR_FILE=target/graphql-cust-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} Graphql.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Graphql.jar"]
