package pl.edu.pg.menu.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.menu.cinemashowtimes.dto.ShowtimesReadDTO;
import pl.edu.pg.menu.cinemashowtimes.entity.Showtime;

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
                                .description(showtime.getMovieTitle() + "at " + showtime.getScreeningTime().toString())
                                .build())
                        .toList())
                .build();
    }
}
