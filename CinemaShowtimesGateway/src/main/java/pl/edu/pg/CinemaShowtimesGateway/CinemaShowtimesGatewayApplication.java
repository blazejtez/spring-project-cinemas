package pl.edu.pg.CinemaShowtimesGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaShowtimesGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaShowtimesGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${rpg.character.url}") String characterUrl,
			@Value("${rpg.profession.url}") String professionUrl,
			@Value("${rpg.user.url}") String userUrl,
			@Value("${rpg.gatewy.host}") String host
	) {
		return builder
				.routes()
				.route("users", route -> route
						.host(host)
						.and()
						.path(
								"/api/users/{uuid}",
								"/api/users"
						)
						.uri(userUrl)
				)
				.route("professions", route -> route
						.host(host)
						.and()
						.path(
								"/api/professions/{uuid}",
								"/api/professions"
						)
						.uri(professionUrl)
				)
				.route("characters", route -> route
						.host(host)
						.and()
						.path(
								"/api/characters",
								"/api/characters/**",
								"/api/users/{uuid}/characters",
								"/api/users/{uuid}/characters/**",
								"/api/professions/{uuid}/characters",
								"/api/professions/{uuid}/characters/**"
						)
						.uri(characterUrl)
				)
				.build();
	}

}
