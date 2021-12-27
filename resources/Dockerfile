From openjdk:11
RUN mkdir -p spring-petclinic/target
COPY target/* spring-petclinic/target/
WORKDIR spring-petclinic
EXPOSE 8080
entrypoint ["java", "-jar", "target/spring-petclinic-2.6.0-SNAPSHOT.jar"]
