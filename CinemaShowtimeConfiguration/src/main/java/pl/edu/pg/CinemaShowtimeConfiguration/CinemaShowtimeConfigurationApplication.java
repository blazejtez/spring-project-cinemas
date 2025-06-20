package pl.edu.pg.CinemaShowtimeConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class CinemaShowtimeConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaShowtimeConfigurationApplication.class, args);
	}

}