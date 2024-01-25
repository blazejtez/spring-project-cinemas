package pl.edu.pg.Cinemas.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import pl.edu.pg.Cinemas.entity.Cinema;
import pl.edu.pg.Cinemas.service.CinemaService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class DataInitializer implements InitializingBean {
	private final CinemaService cinemaService;

	public DataInitializer(CinemaService cinemaService) {
		this.cinemaService = cinemaService;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		        Cinema krewetka = Cinema.builder()
		                .id(UUID.fromString("fe1ad570-dfeb-4c3f-be69-b594c0dd4fff"))
		                .name("Krewetka Cinema")
		                .street("Karmelicka 1")
		                .city("Gdansk")
		                .zipCode("80-434")
		                .employeesNumber(20) // Assuming there are 20 employees
		                .phoneNumber("555-1234")
		                .openingDate(new Date())
		                .build();
		        cinemaService.create(krewetka);
		//		        List<Cinema> cinemas = cinemaService.findAll();

		//
		//        Showtime showtime = Showtime.builder()
		//                .id(UUID.fromString("c60bb33b-cca3-4325-9a73-febc771e5c0e"))
		//                .movieTitle("Dancing in the Dark")
		//                .showRoomName("Big Hall")
		//                .screeningTime(LocalDateTime.now())
		//                .ticketPrice(new BigDecimal("19.99"))
		//                .cinema(krewetka)
		//                .build();
		//        showtimeService.create(showtime);
	}
}
