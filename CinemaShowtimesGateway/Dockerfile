FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="cinema-showtime-gateway"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8085

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:simple-rpg-gateway
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV ISA_GATEWAY_HOST=localhost:8085
ENV ISA_CINEMA_URL=http://localhost:8081
ENV ISA_SHOWTIME_URL=http://localhost:8082


EXPOSE 8085

COPY target/CinemaShowtimeGateway-${VERSION}.jar /opt/CinemaShowtimeGateway/CinemaShowtimeGateway.jar

CMD ["java", "-jar", "/opt/CinemaShowtimeGateway/CinemaShowtimeGateway.jar"]
