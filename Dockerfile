From openjdk:11
COPY spring-petclinic spring-petclinic/
WORKDIR spring-petclinic
EXPOSE 8080
entrypoint ["java", "-jar", "target/spring-petclinic-2.5.0-SNAPSHOT.jar"]
