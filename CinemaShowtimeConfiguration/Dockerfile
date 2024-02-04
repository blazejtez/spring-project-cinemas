FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="cinema-showtime-configuration"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

ENV EUREKA_INSTANCE_HOSTNAME=cinema-showtime-discovery

ENV EUREKA_CLIENT_FETCH_REGISTRY=false
ENV EUREKA_CLIENT_REGISTER_WITH_EUREKA=false
ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE="http://cinema-showtime-discovery:8080/eureka/"

ENV EUREKA_SERVER_ENABLE_SELF_PRESERVATION=false
ENV EUREKA_SERVER_EVICTION_INTERVAL_TIMER_IN_MS=2000

EXPOSE 8080

COPY target/CinemaShowtimeConfiguration-${VERSION}.jar /opt/CinemaShowtimeConfiguration/CinemaShowtimeConfiguration.jar

CMD ["java", "-jar", "/opt/CinemaShowtimeConfiguration/CinemaShowtimeConfiguration.jar"]
