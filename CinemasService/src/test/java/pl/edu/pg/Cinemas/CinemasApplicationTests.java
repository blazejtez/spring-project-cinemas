package pl.edu.pg.Cinemas;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import pl.edu.pg.Cinemas.entity.Cinema;
import pl.edu.pg.Cinemas.event.repository.EventRepository;
import pl.edu.pg.Cinemas.repository.CinemaRepository;
import pl.edu.pg.Cinemas.service.CinemaService;
import pl.edu.pg.Cinemas.util.DataInitializer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CinemasApplication.class, webEnvironment = RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureTestEntityManager
class CinemasApplicationTests {

	@MockBean
	private DataInitializer dataInitializer;

	@MockBean
	private EventRepository eventRepository;

	@Autowired
	private CinemaService cinemaService;

	@Autowired
	private CinemaRepository cinemaRepository;

	@BeforeEach
	public void before() {
		cinemaRepository.deleteAll();
	}

	@AfterEach
	public void after() {
		cinemaRepository.deleteAll();
	}

	@Test
	void findAll() {
		// given
		Cinema cinema1 = new Cinema(UUID.randomUUID(), "Helios", "Sezamkowa", "Gdańsk", "80-226", 10, "123-456-789", new Date());
		cinemaRepository.save(cinema1);

		Cinema cinema2 = new Cinema(UUID.randomUUID(), "Multikino", "Wikązów", "Gdańsk", "80-226", 100, "123-456-111", new Date());
		cinemaRepository.save(cinema2);

		// when
		List<Cinema> results = cinemaService.findAll();

		// then
		assertThat(results).hasSize(2);
		assertThat(results).extracting(Cinema::getStreet, Cinema::getEmployeesNumber).containsExactlyInAnyOrder(tuple("Sezamkowa", 10), tuple("Wikązów", 100));
	}

	@Test
	void create() {
		// given
		Cinema cinema = new Cinema(UUID.randomUUID(), "Helios", "Sezamkowa", "Gdańsk", "80-226", 10, "123-456-789", new Date());

		// when
		cinemaService.create(cinema);

		List<Cinema> results = cinemaRepository.findAll();

		// then
		assertThat(results).hasSize(1);
	}

}
