FROM openjdk:11
ADD target/spring-boot-api.jar spring-boot-api.jar
ENTRYPOINT ["java", "-jar","spring-boot-api.jar"]

