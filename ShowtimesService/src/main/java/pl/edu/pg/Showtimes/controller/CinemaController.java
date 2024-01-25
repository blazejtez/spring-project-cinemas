package pl.edu.pg.Showtimes.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.edu.pg.Showtimes.entity.Cinema;
import pl.edu.pg.Showtimes.function.CinemaCreateDTOToCinema;
import pl.edu.pg.Showtimes.service.CinemaService;

import java.util.UUID;

@Slf4j
@RestController
public class CinemaController {
	private final CinemaService cinemaService;
	private final CinemaCreateDTOToCinema cinemaCreateDTOToCinema;

	@Autowired
	public CinemaController(CinemaService cinemaService, CinemaCreateDTOToCinema cinemaCreateDTOToCinema) {
		this.cinemaService = cinemaService;
		this.cinemaCreateDTOToCinema = cinemaCreateDTOToCinema;
	}

	@PostMapping("api/cinemas/{uuid}")
	ResponseEntity<String> postCinema(@PathVariable UUID uuid) {
		Cinema cinema = this.cinemaCreateDTOToCinema.apply(uuid);
		this.cinemaService.create(cinema);
		log.info("Successfully created cinema with UUID {}. ", uuid);
		String body = "Successfully created.";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "CinemaController");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(body);
	}

	@DeleteMapping("api/cinemas/{uuid}")
	ResponseEntity<String> deleteCinema(@PathVariable UUID uuid) {
		try {
			Cinema cinema = this.cinemaService.findById(uuid);
			this.cinemaService.deleteById(uuid);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Responded", "CinemaController");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body("Succesfully deleted " + uuid.toString());
		} catch (EntityNotFoundException e) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Not Found", "CinemaController");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
		}

	}

}
