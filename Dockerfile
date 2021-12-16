From Ubuntu
ENV export DEBIAN_FRONTEND=noninteractive
RUN apt-get install openjdk-11-jdk -y 
COPY spring-petclinic spring-petclinic/
WORKDIR spring-petclinic
Expose 8080
entrypoint ["java", "-jar", "target/*.jar"]
