package pl.edu.pg.Cinemas.event.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.pg.Cinemas.dto.CinemaCreateDTO;
import pl.edu.pg.Cinemas.entity.Cinema;

import java.util.UUID;

@Repository
public class EventRepository {
	private final RestTemplate restTemplate;

	@Autowired
	public EventRepository(@Value("${isa.showtime.url}") String baseUrl) {
		restTemplate = new RestTemplateBuilder().rootUri(baseUrl).build();
	}

	public void delete(UUID uuid) {
		String uuidASString = uuid.toString();
		restTemplate.delete("/api/cinemas/" + uuidASString);
	}

	public void create(Cinema cinema) {
		String uuid = cinema.getId().toString();
		CinemaCreateDTO cinemaCreateDTO = new CinemaCreateDTO();
		restTemplate.postForLocation("/api/cinemas/" + uuid, cinemaCreateDTO);
	}

}
