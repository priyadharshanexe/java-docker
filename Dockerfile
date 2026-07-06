FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY server.java .

RUN javac server.java

EXPOSE 8080

CMD ["java", "server"]
