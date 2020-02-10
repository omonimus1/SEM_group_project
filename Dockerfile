FROM openjdk:latest
COPY ./target/seMethods-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
<<<<<<< HEAD
ENTRYPOINT ["java", "-jar", "seMethods-0.1.0.1-jar-with-dependencies.jar"]
=======
ENTRYPOINT ["java", "-jar", "seMethods-0.1.0.2-jar-with-dependencies.jar"]
>>>>>>> 8496314d3c3137ba807eed52da8aaafcb6e1f491
