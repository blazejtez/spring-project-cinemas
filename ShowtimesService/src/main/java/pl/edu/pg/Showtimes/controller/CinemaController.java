package pl.edu.pg.Showtimes.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.edu.pg.Showtimes.dto.CinemasReadDTO;
import pl.edu.pg.Showtimes.entity.Cinema;
import pl.edu.pg.Showtimes.function.CinemaCreateDTOToCinema;
import pl.edu.pg.Showtimes.function.CinemasToCinemasReadDTO;
import pl.edu.pg.Showtimes.service.CinemaService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class CinemaController {
	private final CinemaService cinemaService;
	private final CinemaCreateDTOToCinema cinemaCreateDTOToCinema;

	private final CinemasToCinemasReadDTO cinemasToCinemasReadDTO;

	@Autowired
	public CinemaController(CinemaService cinemaService, CinemaCreateDTOToCinema cinemaCreateDTOToCinema, CinemasToCinemasReadDTO cinemasToCinemasReadDTO) {
		this.cinemaService = cinemaService;
		this.cinemaCreateDTOToCinema = cinemaCreateDTOToCinema;
		this.cinemasToCinemasReadDTO = cinemasToCinemasReadDTO;
	}

	@PutMapping("api/showtimes/cinemas/{uuid}")
	ResponseEntity<String> putCinema(@PathVariable UUID uuid) {
		Cinema cinema = this.cinemaCreateDTOToCinema.apply(uuid);
		this.cinemaService.create(cinema);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "CinemaController");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
	}

	@DeleteMapping("api/showtimes/cinemas/{uuid}")
	ResponseEntity<String> deleteCinema(@PathVariable UUID uuid) {
		try {
			Cinema cinema = this.cinemaService.findById(uuid);
			this.cinemaService.deleteById(uuid);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Responded", "CinemaController");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
		} catch (EntityNotFoundException e) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Not Found", "CinemaController");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
		}

	}
	@PostMapping("api/showtimes/cinemas/{uuid}")
	ResponseEntity<String> postCinema(@PathVariable UUID uuid) {
		Cinema cinema = this.cinemaCreateDTOToCinema.apply(uuid);
		this.cinemaService.create(cinema);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "CinemaController");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
	}

	@GetMapping("api/showtimes/cinemas")
	ResponseEntity<CinemasReadDTO> showAllCinemas() {
		List<Cinema> cinemas = cinemaService.findAll();
		CinemasReadDTO cinemasReadDTO = cinemasToCinemasReadDTO.apply(cinemas); // translate between business entities and DTO objects.
		HttpHeaders headers = new HttpHeaders();
		headers.add("Responded", "CinemaController");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(cinemasReadDTO);
	}

}
