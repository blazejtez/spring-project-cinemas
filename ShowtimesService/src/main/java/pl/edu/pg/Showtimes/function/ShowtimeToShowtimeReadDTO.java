package pl.edu.pg.Showtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.Showtimes.dto.ShowtimeReadDTO;
import pl.edu.pg.Showtimes.entity.Showtime;

import java.util.function.Function;

@Component
public class ShowtimeToShowtimeReadDTO implements Function<Showtime, ShowtimeReadDTO> {
    @Override
    public ShowtimeReadDTO apply(Showtime entity) {
        return ShowtimeReadDTO.builder()
                .movieTitle(entity.getMovieTitle())
                .showRoomName(entity.getShowRoomName())
                .ticketPrice(entity.getTicketPrice())
                .screeningTime(entity.getScreeningTime())
                .build();
    }
}