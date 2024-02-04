package pl.edu.pg.CinemaShowtimesGateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;

@SpringBootApplication
@EnableDiscoveryClient
public class CinemaShowtimesGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaShowtimesGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${isa.gateway.host}") String host
    ) {
        return builder
                .routes()
                .route("cinemas", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/cinemas/{uuid}",
                                "/api/cinemas"
                        )
                        .uri("lb://cinemas-service")
                )
                .route("showtimes", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/showtimes",
                                "/api/showtimes/**",
                                "/api/cinemas/{uuid}/showtimes",
                                "/api/cinemas/{uuid}/showtimes/**"
                        )
                        .uri("lb://showtimes-service")
                )
                .build();
    }
}
