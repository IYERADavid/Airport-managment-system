FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app

COPY airport/ ./airport/

RUN find . -name "*.java" > sources.txt && \
    javac -d out @sources.txt && \
    rm sources.txt

RUN echo "Main-Class: airport.AirportSystem" > manifest.txt && \
    jar cfm airport-system.jar manifest.txt -C out . && \
    rm manifest.txt

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/airport-system.jar .

CMD ["java", "-jar", "airport-system.jar"]
