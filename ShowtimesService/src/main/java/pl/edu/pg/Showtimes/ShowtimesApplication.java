package pl.edu.pg.Showtimes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShowtimesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowtimesApplication.class, args);
	}

}
