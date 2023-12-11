package pl.edu.pg.cinema.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.cinema.cinemashowtimes.dto.ShowtimeReadDTO;
import pl.edu.pg.cinema.cinemashowtimes.entity.Showtime;

import java.util.function.Function;

@Component
public class ShowtimeToShowtimeReadDTO implements Function<Showtime, ShowtimeReadDTO> {
    @Override
    public ShowtimeReadDTO apply(Showtime entity) {
        return ShowtimeReadDTO.builder()
                .movieTitle(entity.getMovieTitle())
                .showRoomName(entity.getShowRoomName())
                .ticketPrice(entity.getTicketPrice())
                .numberOfTickets(entity.getNumberOfTickets())
                .screeningTime(entity.getScreeningTime())
                .build();
    }
}