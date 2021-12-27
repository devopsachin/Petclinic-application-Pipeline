From openjdk:11
RUN mkdir -p spring-petclinic/target
COPY spring-petlinic spring-petclinic/
WORKDIR spring-petclinic
EXPOSE 8080
entrypoint ["java", "-jar", "target/spring-petclinic-2.5.0-SNAPSHOT.jar"]
