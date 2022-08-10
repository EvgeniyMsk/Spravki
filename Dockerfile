FROM maven:3.8.4-jdk-8
COPY src /Spravka/src
COPY pom.xml /Spravka
WORKDIR Spravka
RUN mvn clean package