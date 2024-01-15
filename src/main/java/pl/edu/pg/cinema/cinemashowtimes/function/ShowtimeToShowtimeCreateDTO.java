package pl.edu.pg.cinema.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.cinema.cinemashowtimes.dto.ShowtimeCreateDTO;
import pl.edu.pg.cinema.cinemashowtimes.entity.Showtime;

import java.util.function.Function;

@Component
public class ShowtimeToShowtimeCreateDTO implements Function<Showtime, ShowtimeCreateDTO> {


    @Override
    public ShowtimeCreateDTO apply(Showtime entity) {
        return ShowtimeCreateDTO.builder()
                .movieTitle(entity.getMovieTitle())
                .showRoomName(entity.getShowRoomName())
                .ticketPrice(entity.getTicketPrice())
                .screeningTime(entity.getScreeningTime())
                .build();
    }
}
