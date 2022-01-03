From openjdk:11
COPY spring-mvc-showcase spring-petclinic/
WORKDIR spring-petclinic
EXPOSE 8080
entrypoint ["java", "-jar", "target/*.jar"]
