package pl.edu.pg.cinema.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.cinema.cinemashowtimes.dto.ShowtimesReadDTO;
import pl.edu.pg.cinema.cinemashowtimes.entity.Showtime;

import java.util.List;
import java.util.function.Function;

@Component
public class ShowtimesToShowtimesReadDTO implements Function<List<Showtime>, ShowtimesReadDTO> {

    @Override
    public ShowtimesReadDTO apply(List<Showtime> entities) {
        return ShowtimesReadDTO.builder()
                .showtimes(entities.stream()
                        .map(showtime -> ShowtimesReadDTO.Showtime.builder()
                                .id(showtime.getId())
                                //TODO FIX IT
                                .description(showtime.getMovieTitle() + " at " + showtime.getScreeningTime())
                                .build())
                        .toList())
                .build();
    }
}
