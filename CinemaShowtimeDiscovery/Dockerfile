FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="cinema-showtime-discovery"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

EXPOSE 8080

COPY target/CinemaShowtimeDiscovery-${VERSION}.jar /opt/CinemaShowtimeDiscovery/CinemaShowtimeDiscovery.jar

CMD ["java", "-jar", "/opt/CinemaShowtimeDiscovery/CinemaShowtimeDiscovery.jar"]
