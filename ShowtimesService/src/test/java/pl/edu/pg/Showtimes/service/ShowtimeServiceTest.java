package pl.edu.pg.Showtimes.service;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import pl.edu.pg.Showtimes.ShowtimesApplication;
import pl.edu.pg.Showtimes.entity.Cinema;
import pl.edu.pg.Showtimes.entity.Showtime;
import pl.edu.pg.Showtimes.repository.CinemaRepository;
import pl.edu.pg.Showtimes.repository.ShowtimeRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ShowtimesApplication.class, webEnvironment = RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureTestEntityManager
class ShowtimeServiceTest {

	@Autowired
	private ShowtimeService showtimeService;

	@Autowired
	private CinemaRepository cinemaRepository;

	@Autowired
	private ShowtimeRepository showtimeRepository;

	@BeforeEach
	public void before() {
		cinemaRepository.deleteAll();
		showtimeRepository.deleteAll();
	}

	@AfterEach
	public void after() {
		cinemaRepository.deleteAll();
		showtimeRepository.deleteAll();
	}

	@Test
	void findFromCinema() {
		// given
		Cinema cinema1 = Cinema.builder().id(UUID.randomUUID()).build();
		Cinema cinema2 = Cinema.builder().id(UUID.randomUUID()).build();
		cinemaRepository.save(cinema1);
		cinemaRepository.save(cinema2);

		Showtime showtime1 = Showtime.builder().id(UUID.randomUUID()).cinema(cinema1).movieTitle("movie 1").showRoomName("roomName1").build();
		Showtime showtime2 = Showtime.builder().id(UUID.randomUUID()).cinema(cinema2).movieTitle("movie 2").showRoomName("roomName2").build();
		showtimeRepository.save(showtime1);
		showtimeRepository.save(showtime2);

		// when
		List<Showtime> results = showtimeService.findFromCinema(cinema1.getId());

		//then
		assertThat(results).extracting(Showtime::getCinema, Showtime::getMovieTitle).containsExactlyInAnyOrder(tuple(cinema1, showtime1.getMovieTitle()));

	}
}
