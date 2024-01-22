package pl.edu.pg.Showtimes.util;

import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.Showtimes.entity.Cinema;
import pl.edu.pg.Showtimes.entity.Showtime;
import pl.edu.pg.Showtimes.function.ShowtimeCreateDTOToShowtime;
import pl.edu.pg.Showtimes.service.CinemaService;
import pl.edu.pg.Showtimes.service.ShowtimeService;

import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.Date;


@Component
public class DataInitializer implements InitializingBean {
    private final ShowtimeService showtimeService;
    private final CinemaService cinemaService;
    private final ShowtimeCreateDTOToShowtime showtimeCreateDTOToShowtime;
    @Autowired
    public DataInitializer(ShowtimeService showtimeService, CinemaService cinemaService, ShowtimeCreateDTOToShowtime showtimeCreateDTOToShowtime) {
        this.showtimeService = showtimeService;
        this.cinemaService = cinemaService;
        this.showtimeCreateDTOToShowtime = showtimeCreateDTOToShowtime;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Cinema krewetka = Cinema.builder()
                .id(UUID.fromString("1318ad0e-d021-4662-b962-6d419459cfc6"))
                .build();
        cinemaService.create(krewetka);
        Showtime showtime = Showtime.builder()
                .id(UUID.fromString("c60bb33b-cca3-4325-9a73-febc771e5c0e"))
                .movieTitle("Dancing in the Dark")
                .showRoomName("Big Hall")
                .screeningTime(LocalDateTime.now())
                .ticketPrice(new BigDecimal("19.99"))
                .cinema(krewetka)
                .build();
        showtimeService.create(showtime);
        List<Showtime> showtimes = showtimeService.findAll();
        krewetka.setShowtimes(showtimes);
    }
    @SneakyThrows
    private byte[] getResourceAsByteArray(String name) {
        try (InputStream is = this.getClass().getResourceAsStream(name)) {
            return is.readAllBytes();
        }
    }
}
