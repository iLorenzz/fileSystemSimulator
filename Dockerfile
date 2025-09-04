FROM openjdk:21-jdk-slim

WORKDIR /app
COPY ./fileSystemCore/src /app

WORKDIR /app
RUN javac Main.java

CMD ["java", "Main"]