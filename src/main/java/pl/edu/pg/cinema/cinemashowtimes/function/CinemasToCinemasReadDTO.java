package pl.edu.pg.cinema.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.cinema.cinemashowtimes.dto.CinemasReadDTO;
import pl.edu.pg.cinema.cinemashowtimes.entity.Cinema;

import java.util.List;
import java.util.function.Function;
@Component
public class CinemasToCinemasReadDTO implements Function<List<Cinema>, CinemasReadDTO> {
    @Override
    public CinemasReadDTO apply(List<Cinema> entities) {
        return CinemasReadDTO.builder()
                .cinemas(entities.stream()
                        .map( cinema -> CinemasReadDTO.Cinema.builder()
                                .id(cinema.getId())
                                //TODO FIX IT
                                .description(cinema.getName() + " in " + cinema.getCity())
                                .build())
                        .toList())
                .build();
    }
}
