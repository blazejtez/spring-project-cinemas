package pl.edu.pg.CinemaShowtimesGateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;

@SpringBootApplication
public class CinemaShowtimesGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaShowtimesGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${isa.cinema.url}") String cinemaUrl,
			@Value("${isa.showtime.url}") String showtimeUrl,
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
						.uri(cinemaUrl)
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
						.uri(showtimeUrl)
				)
				.build();
	}
//	@Component
//	public class Debugger {
//		private final RouteLocator routeLocator;
//
//		@Autowired
//		public Debugger(RouteLocator routeLocator) {
//			this.routeLocator = routeLocator;
//		}
//
//		@PostConstruct
//		public void debug() {
//			this.routeLocator.getRoutes();
//		}
//
//	}
}
