From openjdk:11
COPY spring-petclinic spring-petclinic/
WORKDIR spring-petclinic
Expose 8080
entrypoint ["java", "-jar", "target/spring-petclinic-2.5.0-SNAPSHOT.jar"]
