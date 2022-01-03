From openjdk:11
RUN mkdir -p spring-petclinic/target
COPY target/* spring-petclinic/target/
WORKDIR spring-petclinic
EXPOSE 8080
entrypoint ["java", "-jar", "target/*.jar"]
