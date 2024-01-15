package pl.edu.pg.cinema.cinemashowtimes.util;

import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.cinema.cinemashowtimes.dto.CinemaCreateDTO;
import pl.edu.pg.cinema.cinemashowtimes.dto.ShowtimeCreateDTO;
import pl.edu.pg.cinema.cinemashowtimes.entity.Cinema;
import pl.edu.pg.cinema.cinemashowtimes.function.CinemaToCinemaCreateDTO;
import pl.edu.pg.cinema.cinemashowtimes.service.CinemaService;
import pl.edu.pg.cinema.cinemashowtimes.service.ShowtimeService;

import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.Date;


@Component
public class DataInitializer implements InitializingBean {
    private final ShowtimeService showtimeService;
    private final CinemaService cinemaService;
    private final CinemaToCinemaCreateDTO cinemaToCinemaCreateDTO;
    @Autowired
    public DataInitializer(ShowtimeService showtimeService, CinemaService cinemaService, CinemaToCinemaCreateDTO cinemaToCinemaCreateDTO) {
        this.showtimeService = showtimeService;
        this.cinemaService = cinemaService;
        this.cinemaToCinemaCreateDTO = cinemaToCinemaCreateDTO;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        CinemaCreateDTO krewetkaDTO = CinemaCreateDTO.builder()
                .name("Krewetka Cinema")
                .street("Karmelicka 1")
                .city("Gdansk")
                .zipCode("80-434")
                .employeesNumber(20) // Assuming there are 20 employees
                .phoneNumber("555-1234")
                .openingDate(new Date())
                .build();
        cinemaService.create(krewetkaDTO);

        List<Cinema> cinemas = cinemaService.findAll();


        ShowtimeCreateDTO showtime = ShowtimeCreateDTO
                .builder()
                .movieTitle("Dancing in the Dark")
                .showRoomName("Big Hall")
                .screeningTime(LocalDateTime.now())
                .ticketPrice(new BigDecimal("19.99"))
                .build();
        showtimeService.create(showtime, null);

    }
    @SneakyThrows
    private byte[] getResourceAsByteArray(String name) {
        try (InputStream is = this.getClass().getResourceAsStream(name)) {
            return is.readAllBytes();
        }
    }
}
