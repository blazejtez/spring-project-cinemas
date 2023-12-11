package pl.edu.pg.cinema.cinemashowtimes.util;

import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.cinema.cinemashowtimes.dto.CinemaCreateDTO;
import pl.edu.pg.cinema.cinemashowtimes.entity.Cinema;
import pl.edu.pg.cinema.cinemashowtimes.function.CinemaToCinemaCreateDTO;
import pl.edu.pg.cinema.cinemashowtimes.service.CinemaService;
import pl.edu.pg.cinema.cinemashowtimes.service.ShowtimeService;

import java.io.InputStream;
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
        Cinema krewetka = Cinema.builder()
                .id(UUID.fromString("1318ad0e-d021-4662-b962-6d419459cfc5"))
                .name("Krewetka Cinema")
                .street("Karmelicka 1")
                .city("Gdansk")
                .zipCode("80-434")
                .employeesNumber(20) // Assuming there are 20 employees
                .phoneNumber("555-1234")
                .description("A fantastic cinema experience")
                .openingDate(new Date())
                .build();
        CinemaCreateDTO krewetkaDTO = cinemaToCinemaCreateDTO.apply(krewetka);
        cinemaService.create(krewetkaDTO);
}
    @SneakyThrows
    private byte[] getResourceAsByteArray(String name) {
        try (InputStream is = this.getClass().getResourceAsStream(name)) {
            return is.readAllBytes();
        }
    }
}
