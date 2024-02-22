FROM openjdk:21
EXPOSE 8080
ADD target/spring-boot-cred.jar spring-boot-cred.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-cred.jar"]