#!/usr/bin/env bash

# Builds all applications and all docker images using Dockerfile and tags it based on org.opencontainers.image.version
# label in Dockerfile.

#######################################
# Script main function. Builds all applications and all docker images using Dockerfile and tags it based on
# org.opencontainers.image.version label in Dockerfile.
# Arguments:
#   None.
#######################################
function main() {
    cd ./CinemaShowtimeDiscovery/; sh ./build.sh; cd ..
    cd ./CinemasService/; sh ./build.sh; cd ..
    cd ./ShowtimesService/; sh ./build.sh; cd ..
    cd ./CinemaShowtimesGateway/; sh ./build.sh; cd ..
#    cd ./angularclient/; sh ./build.sh; cd ..
    docker-compose stop
    docker-compose rm -f
    docker-compose up -d
}

main "$@"
