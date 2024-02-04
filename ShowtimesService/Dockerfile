FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="showtimes"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_CONFIG_IMPORT=optional:configserver:http://cinema-showtime-configuration:8080
EXPOSE 8080

COPY target/Showtimes-${VERSION}.jar /opt/Showtimes/Showtimes.jar

CMD ["java", "-jar", "/opt/Showtimes/Showtimes.jar"]
