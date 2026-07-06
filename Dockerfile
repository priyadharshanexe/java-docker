FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY server.java .

RUN javac server.java

EXPOSE 8880

CMD ["java", "server"]
