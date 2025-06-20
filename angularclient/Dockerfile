FROM nginx:1.23.3
LABEL authors="Blazej"

LABEL org.opencontainers.image.title="angularclient"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV API_URL http://cinema-showtime-gateway:8085/api/

EXPOSE 80

COPY dist/angularclient/browser /usr/share/nginx/html/
COPY docker/etc/nginx/templates/ /etc/nginx/templates/

