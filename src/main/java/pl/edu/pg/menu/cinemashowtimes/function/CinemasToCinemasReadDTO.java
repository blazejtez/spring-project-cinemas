package pl.edu.pg.menu.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.menu.cinemashowtimes.dto.CinemasReadDTO;
import pl.edu.pg.menu.cinemashowtimes.entity.Cinema;

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
                                .description(cinema.getDescription())
                                .build())
                        .toList())
                .build();
    }
}
